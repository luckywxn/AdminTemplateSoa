
package com.strongculture.service.dao.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@SuppressWarnings({"rawtypes", "unchecked"})
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 2603579625943505099L;
    //当前页
    private long pageNum;
    //每页的数量
    private long pageSize;

    //总记录数
    private long total;
    //总页数
    private long pages;
    //结果集
    private List<T> records;

    /**
     * 包装Page对象
     *
     * @param list page结果
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getCurrent();
            this.pageSize = page.getSize();

            this.pages = page.getPages();
            this.records = page.getRecords();
            this.total = page.getTotal();

        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.pages = this.pageSize > 0 ? 1 : 0;
            this.records = list;
            this.total = list.size();
        }
    }

    public PageInfo(List<T> list, Long total) {
        this.records = list;
        this.total = total;
    }

    public PageInfo(Page page) {
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();

        this.pages = page.getPages();
        this.records = page.getRecords();
        this.total = page.getTotal();
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> list) {
        this.records = list;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", records=").append(records);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}
