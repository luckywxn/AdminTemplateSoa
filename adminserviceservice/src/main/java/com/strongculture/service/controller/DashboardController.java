package com.strongculture.service.controller;

import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.contact.entity.dashboard.DashboardDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "面板服务")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @ApiOperation(value = "图标分析数据",notes = "图标分析数据")
    @PostMapping(value = "/analysisChartData")
    public BaseResponse<DashboardDataVo> analysisChartData(){
        BaseResponse response = new BaseResponse();
        response.SUCCESS(new DashboardDataVo());
        return response;
    }

}
