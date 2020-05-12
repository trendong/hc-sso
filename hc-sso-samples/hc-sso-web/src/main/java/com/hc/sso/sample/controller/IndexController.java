package com.hc.sso.sample.controller;

import com.hc.sso.core.conf.Conf;
import com.hc.sso.core.entity.ReturnT;
import com.hc.sso.core.user.SsoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/12
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        SsoUser ssoUser = (SsoUser) request.getAttribute(Conf.SSO_USER);
        model.addAttribute("user", ssoUser);
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public ReturnT<SsoUser> json(HttpServletRequest request) {
        SsoUser ssoUser = (SsoUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT(ssoUser);
    }

}
