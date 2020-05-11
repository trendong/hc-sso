package com.hc.sso.core.exception;

/**
 * @Author: HuaChenG
 * @Description: 异常
 * @Date: Create in 2020/05/11
 */
public class SsoException extends RuntimeException {

    private static final long serialVersionUID = 42L;

    public SsoException(String msg) {
        super(msg);
    }

    public SsoException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SsoException(Throwable cause) {
        super(cause);
    }

}
