package com.common.model.bo.biz;

/**
 * @Package: com.common.model.bo.biz
 * @Description:
 * @author: jklofs
 * @date: 2018/5/4 下午9:13
 */
public class RedisSpecificationBo {
    private Integer specId;
    private String appCode;
    private int num;

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "RedisSpecificationBo{" +
                "specId=" + specId +
                ", appCode='" + appCode + '\'' +
                ", num=" + num +
                '}';
    }
}
