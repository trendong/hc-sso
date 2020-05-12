package com.hc.sso.sample.config;

import com.hc.sso.core.conf.Conf;
import com.hc.sso.core.filter.WebFilter;
import com.hc.sso.core.util.JedisUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/12
 */
@Configuration
public class SsoConfig implements DisposableBean {

    @Value("${hc.sso.server}")
    private String hcSsoServer;

    @Value("${hc.sso.logout.path}")
    private String hcSsoLogoutPath;

    @Value("${hc.sso.redis.address}")
    private String hcSsoRedisAddress;

    @Value("${hc.sso.excluded.paths}")
    private String hcSsoExcludedPaths;

    @Bean
    public FilterRegistrationBean filterRegistration() {

        // hc-sso, redis init
        JedisUtil.init(hcSsoRedisAddress);

        // hc-sso, filter init
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setName("WebFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        registration.setFilter(new WebFilter());
        registration.addInitParameter(Conf.SSO_SERVER, hcSsoServer);
        registration.addInitParameter(Conf.SSO_LOGOUT_PATH, hcSsoLogoutPath);
        registration.addInitParameter(Conf.SSO_EXCLUDED_PATHS, hcSsoExcludedPaths);

        return registration;
    }

    @Override
    public void destroy() throws Exception {
        // hc-sso, redis close
        JedisUtil.close();
    }
}
