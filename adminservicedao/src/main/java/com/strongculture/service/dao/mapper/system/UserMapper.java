package com.strongculture.service.dao.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.UserPO;
import com.strongculture.service.dao.request.UserListReqVo;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPO> {
    default UserPO getByLoginAccount(String loginAccount){
        return selectOne(new LambdaQueryWrapperX<UserPO>()
                .eq(UserPO::getLoginAccount, loginAccount)
                .eq(UserPO::getOkDel, false)
        );
    }

    default List<UserPO> selectList(UserListReqVo reqVo) {
        return selectList(new LambdaQueryWrapperX<UserPO>()
                .likeIfPresent(UserPO::getLoginAccount, reqVo.getLoginAccount())
                .likeIfPresent(UserPO::getUserName, reqVo.getUserName())
                .eqIfPresent(UserPO::getStatus, reqVo.getStatus())
                .eq(UserPO::getOkDel, false)
        );
    }

}
