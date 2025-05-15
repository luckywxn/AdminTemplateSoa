package com.strongculture.service.contact.entity.dashboard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DashboardDataVo {
    private List<VisitDataVo> visitData;
    private List<VisitData2VO> visitData2;
    private List<SalesDataVo> salesData;
    private List<SearchDataVo> searchData;
    private List<OfflineDataVo> offlineData;
    private List<OfflineChartDataVo> offlineChartData;
    private List<SalesTypeDataVo> salesTypeData;
    private List<SalesTypeDataOnlineVo> salesTypeDataOnline;
    private List<SalesTypeDataOfflineVo> salesTypeDataOffline;
    private List<RadarDataVo> radarData;

    public DashboardDataVo() {
        List<VisitDataVo> visitData = new ArrayList<>();
        visitData.add(new VisitDataVo("2025-04-17", 9));
        visitData.add(new VisitDataVo("2025-04-18", 6));
        visitData.add(new VisitDataVo("2025-04-19", 12));
        this.visitData = visitData;
        List<VisitData2VO> visitData2 = new ArrayList<>();
        this.visitData2 = visitData2;
        List<SalesDataVo> salesData = new ArrayList<>();
        this.salesData = salesData;
        List<SearchDataVo> searchData = new ArrayList<>();
        this.searchData = searchData;
        List<OfflineDataVo> offlineData = new ArrayList<>();
        this.offlineData = offlineData;
        List<OfflineChartDataVo> offlineChartData = new ArrayList<>();
        this.offlineChartData = offlineChartData;
        List<SalesTypeDataVo> salesTypeData = new ArrayList<>();
        this.salesTypeData = salesTypeData;
        List<SalesTypeDataOnlineVo> salesTypeDataOnline = new ArrayList<>();
        this.salesTypeDataOnline = salesTypeDataOnline;
        List<SalesTypeDataOfflineVo> salesTypeDataOffline = new ArrayList<>();
        this.salesTypeDataOffline = salesTypeDataOffline;
        List<RadarDataVo> radarData = new ArrayList<>();
        this.radarData = radarData;
    }

}
