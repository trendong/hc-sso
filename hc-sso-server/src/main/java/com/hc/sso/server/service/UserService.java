package com.hc.sso.server.service;

import com.hc.sso.core.entity.ReturnT;
import com.hc.sso.server.core.model.UserInfo;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/11
 */
public interface UserService {

    ReturnT<UserInfo> findUser(String username, String password);
}
