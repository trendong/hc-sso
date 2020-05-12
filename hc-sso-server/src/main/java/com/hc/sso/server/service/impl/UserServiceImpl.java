package com.hc.sso.server.service.impl;

import com.hc.sso.core.entity.ReturnT;
import com.hc.sso.server.core.model.UserInfo;
import com.hc.sso.server.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HuaChenG
 * @Description:  sso server (for app)
 * @Date: Create in 2020/05/11
 */
@Service
public class UserServiceImpl implements UserService {

    private static List<UserInfo> mockUserList = new ArrayList<>();
    static {
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(1000+i);
            userInfo.setUsername("user" + (i>0?String.valueOf(i):""));
            userInfo.setPassword("123456");
            mockUserList.add(userInfo);
        }
    }

    @Override
    public ReturnT<UserInfo> findUser(String username, String password) {
        if (username==null || username.trim().length()==0) {
            return new ReturnT<UserInfo>(ReturnT.FAIL_CODE, "Please input username.");
        }
        if (password==null || password.trim().length()==0) {
            return new ReturnT<UserInfo>(ReturnT.FAIL_CODE, "Please input password.");
        }

        // mock user
        for (UserInfo mockUser: mockUserList) {
            if (mockUser.getUsername().equals(username) &&
                mockUser.getPassword().equals(password)) {
                return new ReturnT<UserInfo>(mockUser);
            }
        }

        return new ReturnT<UserInfo>(ReturnT.FAIL_CODE, "username or password is invalid.");

    }

}
