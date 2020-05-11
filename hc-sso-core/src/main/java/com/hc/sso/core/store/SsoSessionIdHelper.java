package com.hc.sso.core.store;

import com.hc.sso.core.user.SsoUser;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/11
 */
public class SsoSessionIdHelper {

    /**
     * make client sessionId
     *
     * @param ssoUser
     * @return
     */
    public static String makeSessionId(SsoUser ssoUser){
        String sessionId = ssoUser.getUserid().concat("_").concat(ssoUser.getVersion());
        return sessionId;
    }

    /**
     * parse storeKey from sessionId
     *
     * @param sessionId
     * @return
     */
    public static String parseStoreKey(String sessionId) {
        if (sessionId!=null && sessionId.indexOf("_")>-1) {
            String[] sessionIdArr = sessionId.split("_");
            if (sessionIdArr.length==2
                    && sessionIdArr[0]!=null
                    && sessionIdArr[0].trim().length()>0) {
                String userId = sessionIdArr[0].trim();
                return userId;
            }
        }
        return null;
    }

    /**
     * parse version from sessionId
     *
     * @param sessionId
     * @return
     */
    public static String parseVersion(String sessionId) {
        if (sessionId!=null && sessionId.indexOf("_")>-1) {
            String[] sessionIdArr = sessionId.split("_");
            if (sessionIdArr.length==2
                    && sessionIdArr[1]!=null
                    && sessionIdArr[1].trim().length()>0) {
                String version = sessionIdArr[1].trim();
                return version;
            }
        }
        return null;
    }

}
