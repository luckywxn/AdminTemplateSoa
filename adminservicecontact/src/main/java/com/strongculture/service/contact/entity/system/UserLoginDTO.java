package com.strongculture.service.contact.entity.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserLoginDTO {
    @Schema(name="登录账户")
    private String username;
    @Schema(name="登录密码")
    private String password;
    @Schema(name = "验证码" ,required = false)
    private String validateCode;
}
