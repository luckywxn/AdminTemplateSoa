package com.strongculture.service.contact.entity.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdatePasswordDTO {
    @NotEmpty(message = "用户账号不能为空")
    @ApiModelProperty(value="用户账户")
    private String loginAccount;
    @NotEmpty(message = "旧密码不能为空")
    @ApiModelProperty(value="旧密码")
    private String oldPassword;
    @NotEmpty(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码")
    private String newPassword;

}
