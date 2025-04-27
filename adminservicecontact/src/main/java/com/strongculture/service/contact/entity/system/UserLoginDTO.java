package com.strongculture.service.contact.entity.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginDTO {
    @ApiModelProperty(value="登录账户")
    private String username;
    @ApiModelProperty(value="登录密码")
    private String password;
    @ApiModelProperty(value = "验证码" ,required = false)
    private String validateCode;
}
