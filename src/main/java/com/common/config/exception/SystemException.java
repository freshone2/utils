package com.common.config.exception;

/**
 * Created by boluome on 2017/6/28.
 */
public class SystemException extends Exception {
    private int resultCode;
    private String resultMessage;

    public SystemException(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
