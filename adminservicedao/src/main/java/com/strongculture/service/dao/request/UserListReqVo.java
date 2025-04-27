package com.strongculture.service.dao.request;

import com.strongculture.service.contact.entity.BasePageRequest;
import lombok.Data;

/**
 * @Author lucky_wxn
 * @Date 13/11/2023 下午12:25
 * @Content
 */
@Data
public class UserListReqVo extends BasePageRequest {
    private String loginAccount;
    private String userName;
    private Integer status;
}
