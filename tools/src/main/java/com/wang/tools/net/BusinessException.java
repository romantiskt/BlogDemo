
package com.wang.tools.net;

/**
 * 业务异常类.
 */
public class BusinessException extends Exception {
    /**
     * 业务异常.
     */
    public BusinessException() {

    }

    /**
     * 业务异常.
     *
     * @param message 消息
     */
    public BusinessException(String message) {
        super(message);
    }
}
