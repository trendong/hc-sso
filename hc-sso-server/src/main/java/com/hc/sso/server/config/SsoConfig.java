package com.hc.sso.server.config;

import com.hc.sso.core.store.SsoLoginStore;
import com.hc.sso.core.util.JedisUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/11
 */
@Configuration
public class SsoConfig implements InitializingBean, DisposableBean {

    @Value("${hc.sso.redis.address}")
    private String redisAddress;
    @Value("${hc.sso.redis.expire.minute}")
    private int redisExpireMinute;

    @Override
    public void destroy() throws Exception {
        JedisUtil.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SsoLoginStore.setRedisExpireMinute(redisExpireMinute);
        JedisUtil.init(redisAddress);

    }

}
