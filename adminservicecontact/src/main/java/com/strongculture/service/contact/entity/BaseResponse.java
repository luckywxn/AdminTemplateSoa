package com.strongculture.service.contact.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseResponse<T> {
    @ApiModelProperty(value = "接口状态码")
    private Integer code;
    @ApiModelProperty(value = "提示信息")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;
    @ApiModelProperty(value = "总计")
    private Long total;

    public BaseResponse SUCCESS(){
        this.code = 200;
        this.message = "成功";
        return this;
    }
    public BaseResponse SUCCESS(T data){
        this.code = 200;
        this.message = "成功";
        this.data = data;
        return this;
    }


    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<T>(200, data);
    }

    public BaseResponse FAIL(){
        this.code = 500;
        this.message = "失败";
        return this;
    }

    public BaseResponse FAIL(String message){
        this.code = 500;
        this.message = message;
        return this;
    }

    public BaseResponse FAIL(Integer code,String message){
        this.code = code;
        this.message = message;
        return this;
    }


    public BaseResponse(){
        this.code = 200;
        this.message = "成功";
    }

    public BaseResponse(Integer code,T data){
        this.code = code;
        this.message = "成功";
        this.data = data;
    }

}
