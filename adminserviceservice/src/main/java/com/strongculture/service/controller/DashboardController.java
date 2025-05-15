package com.strongculture.service.controller;

import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.contact.entity.dashboard.DashboardDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Slf4j
@Tag(name = "面板服务")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Operation(tags = "图标分析数据")
    @PostMapping(value = "/analysisChartData")
    public BaseResponse<DashboardDataVo> analysisChartData(){
        BaseResponse response = new BaseResponse();
        response.SUCCESS(new DashboardDataVo());
        return response;
    }

}
