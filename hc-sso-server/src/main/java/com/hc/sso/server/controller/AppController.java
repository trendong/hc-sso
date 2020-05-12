package com.hc.sso.server.controller;

import com.hc.sso.core.entity.ReturnT;
import com.hc.sso.core.login.TokenLoginHelper;
import com.hc.sso.core.store.SsoLoginStore;
import com.hc.sso.core.store.SsoSessionIdHelper;
import com.hc.sso.core.user.SsoUser;
import com.hc.sso.server.core.model.UserInfo;
import com.hc.sso.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/11
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    /**
     * Login
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ReturnT<String> login(String username, String password) {

        // valid login
        ReturnT<UserInfo> result = userService.findUser(username, password);
        if (result.getCode() != ReturnT.SUCCESS_CODE) {
            return new ReturnT<String>(result.getCode(), result.getMsg());
        }

        // 1、make sso user
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserid(String.valueOf(result.getData().getUserid()));
        ssoUser.setUsername(result.getData().getUsername());
        ssoUser.setVersion(UUID.randomUUID().toString().replaceAll("-", ""));
        ssoUser.setExpireMinute(SsoLoginStore.getRedisExpireMinute());
        ssoUser.setExpireFreshTime(System.currentTimeMillis());


        // 2、generate sessionId + storeKey
        String sessionId = SsoSessionIdHelper.makeSessionId(ssoUser);

        // 3、login, store storeKey
        TokenLoginHelper.login(sessionId, ssoUser);

        // 4、return sessionId
        return new ReturnT<String>(sessionId);
    }

    /**
     * logincheck
     *
     * @param sessionId
     * @return
     */
    @RequestMapping("/logincheck")
    @ResponseBody
    public ReturnT<SsoUser> logincheck(String sessionId) {

        // logout
        SsoUser ssoUser = TokenLoginHelper.loginCheck(sessionId);
        if (ssoUser == null) {
            return new ReturnT<SsoUser>(ReturnT.FAIL_CODE, "sso not login.");
        }
        return new ReturnT<SsoUser>(ssoUser);
    }

}
