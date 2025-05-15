package com.strongculture.service.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.dao.entity.system.SystemOperationLogPO;
import com.strongculture.service.common.LoginPassport;
import com.strongculture.service.service.system.SystemOperationLogService;
import com.strongculture.service.dao.request.OperationLogListReqVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@Tag(name="系统操作日志")
public class SystemOperationLogController {

    @Autowired
    private SystemOperationLogService systemOperationLogService;

    @Operation(tags = "系统操作日志列表")
    @LoginPassport
    @RequestMapping(value = "/system/operation/log/selectList",method = RequestMethod.POST)
    public BaseResponse<List<SystemOperationLogPO>> selectList(@RequestBody OperationLogListReqVo reqVo){
        BaseResponse<List<SystemOperationLogPO>> result = new BaseResponse<>();
        Calendar c = Calendar.getInstance();
        c.setTime(reqVo.getCreatedAtEnd());
        c.add(Calendar.DAY_OF_MONTH, 1);// +1天
        reqVo.setCreatedAtEnd(c.getTime());
        PageHelper.startPage(reqVo.getCurrent(),reqVo.getPageSize());
        PageInfo<SystemOperationLogPO> pageInfo=new PageInfo<SystemOperationLogPO>(systemOperationLogService.selectList(reqVo));
        result.setTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        result.SUCCESS();
        return result;
    }
}
