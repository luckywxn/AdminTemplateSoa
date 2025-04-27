package com.strongculture.service.common.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.*;
import org.apache.poi.xssf.usermodel.*;

@Slf4j
public   class ExcelCopySheetUtil {

    public ExcelCopySheetUtil() { }

    public static void copySheets(SXSSFWorkbook wb,SXSSFSheet newSheet, XSSFSheet sheet) {
        copySheets(wb,newSheet, sheet, true);
    }

    public static void copySheets(SXSSFWorkbook wb, SXSSFSheet newSheet, XSSFSheet sheet, boolean copyStyle) {
        int maxColumnNum = 0;
        Map styleMap = (copyStyle) ? new HashMap(): null;
        log.info("sheet firstRowNum {} lastRowNum {}",sheet.getFirstRowNum(),sheet.getLastRowNum());
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            if(i < 0){
                continue;
            }
            SXSSFRow creatRow = newSheet.createRow(i);
            XSSFRow oldRow = sheet.getRow(i);
            if (oldRow != null) {
                ExcelCopySheetUtil.copyRow( newSheet,sheet,creatRow,oldRow, styleMap);
                if (oldRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = oldRow.getLastCellNum();
                }
            }
        }

        for (int i = 0; i <= maxColumnNum; i++) {    //设置列宽
            newSheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }

        //复制图片
        SXSSFDrawing drawingPatriarch = newSheet.createDrawingPatriarch();
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            if (dr instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if(shape instanceof XSSFPicture){
                        XSSFPicture pic = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = pic.getPreferredSize();
                        int pictureIdx = wb.addPicture(pic.getPictureData().getData(), SXSSFWorkbook.PICTURE_TYPE_PNG);
                        drawingPatriarch.createPicture(anchor,pictureIdx);
                    }
                }
            }
        }
    }

    /**
     * 复制并合并单元格
     * @param createSheet
     * @param sheet
     * @param creatRow
     * @param oldRow
     * @param styleMap
     */
    public static void copyRow(SXSSFSheet createSheet, XSSFSheet sheet, SXSSFRow creatRow, XSSFRow oldRow, Map styleMap) {

        Set mergedRegions = new TreeSet();
        creatRow.setHeight(oldRow.getHeight());
        int deltaRows = creatRow.getRowNum() - oldRow.getRowNum(); //如果copy到另一个sheet的起始行数不同
        for (int j = oldRow.getFirstCellNum(); j <= oldRow.getLastCellNum(); j++) {
            if(j < 0){
                continue;
            }
            try {
                SXSSFCell newCell = creatRow.getCell(j); // new cell
                XSSFCell oldCell = oldRow.getCell(j); // old cell
                if (oldCell != null) {
                    if (newCell == null) {
                        newCell = creatRow.createCell(j);
                    }

                    copyCell(newCell, oldCell, styleMap);

                    CellRangeAddress mergedRegion = getMergedRegion(sheet,oldRow.getRowNum(), (short) oldCell.getColumnIndex());

                    if (mergedRegion != null) {
                        CellRangeAddress newMergedRegion = new CellRangeAddress(
                                mergedRegion.getFirstRow() + deltaRows,
                                mergedRegion.getLastRow() + deltaRows, mergedRegion
                                .getFirstColumn(), mergedRegion
                                .getLastColumn());

                        CellRangeAddressWrapper wrapper = new CellRangeAddressWrapper(newMergedRegion);

                        if (isNewMergedRegion(wrapper, mergedRegions)) {
                            mergedRegions.add(wrapper);
                            createSheet.addMergedRegion(wrapper.range);
                        }
                    }
                }
            }catch (Exception e){
                log.error("j = {}",j,e);
            }
        }
    }

    /**
     * 把原来的Sheet中cell(列)的样式和数据类型复制到新的sheet的cell(列)中      *
     * @param  createCell
     * @param  cell
     * @param styleMap
     */

    public static void copyCell(SXSSFCell createCell, XSSFCell cell,Map styleMap) {
        if (styleMap != null) {
            int stHashCode = cell.getCellStyle().hashCode();
            CellStyle newCellStyle = (CellStyle)styleMap.get(stHashCode);

            if (newCellStyle == null) {
                newCellStyle = createCell.getSheet().getWorkbook()
                        .createCellStyle();
                newCellStyle.cloneStyleFrom(cell.getCellStyle());
                styleMap.put(stHashCode, newCellStyle);

            }
            newCellStyle.setLocked(false);
            createCell.setCellStyle(newCellStyle);
        }

        switch (cell.getCellType()) {
            case STRING:
                createCell.setCellValue(cell.getStringCellValue());
                break;
            case NUMERIC:
                String cellValue;
                double num = cell.getNumericCellValue();
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = DateUtil.getJavaDate(num);
                    cellValue = sdf.format(date);
                } else {
                    BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                    cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
                }
                createCell.setCellValue(cellValue);
                break;
            case BLANK:
                createCell.setCellType(CellType.BLANK);
                break;
            case BOOLEAN:
                createCell.setCellValue(cell.getBooleanCellValue());
                break;
            case ERROR:
                createCell.setCellErrorValue(cell.getErrorCellValue());
                break;
            case FORMULA:
                createCell.setCellFormula(cell.getCellFormula());
                break;
            default:
                break;
        }
    }

// 获取merge对象
    public static CellRangeAddress getMergedRegion(XSSFSheet sheet, int rowNum,short cellNum) {
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress merged = sheet.getMergedRegion(i);
            if (merged.isInRange(rowNum, cellNum)) {
                return merged;
            }
        }
        return null;
    }

    private static boolean isNewMergedRegion(
            CellRangeAddressWrapper newMergedRegion,
            Set mergedRegions) {
        boolean bool = mergedRegions.contains(newMergedRegion);
        return !bool;

    }

}
