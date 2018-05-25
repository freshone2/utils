package com.common.model.bo.freight;

/**
 * @Package: com.common.model.bo.freight
 * @Description:
 * @author: jklofs
 * @date: 2018/5/8 下午9:07
 */
public class FreightBo {
    private Double minimumIntervalWithSTO;

    private Double minimumIntervalWithSF;

    private Double middleIntervalWithSTO;

    private Double middleIntervalWithSF;

    private Double maximumIntervalWithSTO;

    private Double maximumIntervalWithSF;

    public Double getMinimumIntervalWithSTO() {
        return minimumIntervalWithSTO;
    }

    public void setMinimumIntervalWithSTO(Double minimumIntervalWithSTO) {
        this.minimumIntervalWithSTO = minimumIntervalWithSTO;
    }

    public Double getMinimumIntervalWithSF() {
        return minimumIntervalWithSF;
    }

    public void setMinimumIntervalWithSF(Double minimumIntervalWithSF) {
        this.minimumIntervalWithSF = minimumIntervalWithSF;
    }

    public Double getMiddleIntervalWithSTO() {
        return middleIntervalWithSTO;
    }

    public void setMiddleIntervalWithSTO(Double middleIntervalWithSTO) {
        this.middleIntervalWithSTO = middleIntervalWithSTO;
    }

    public Double getMiddleIntervalWithSF() {
        return middleIntervalWithSF;
    }

    public void setMiddleIntervalWithSF(Double middleIntervalWithSF) {
        this.middleIntervalWithSF = middleIntervalWithSF;
    }

    public Double getMaximumIntervalWithSTO() {
        return maximumIntervalWithSTO;
    }

    public void setMaximumIntervalWithSTO(Double maximumIntervalWithSTO) {
        this.maximumIntervalWithSTO = maximumIntervalWithSTO;
    }

    public Double getMaximumIntervalWithSF() {
        return maximumIntervalWithSF;
    }

    public void setMaximumIntervalWithSF(Double maximumIntervalWithSF) {
        this.maximumIntervalWithSF = maximumIntervalWithSF;
    }

    @Override
    public String toString() {
        return "FreightBo{" +
                "minimumIntervalWithSTO=" + minimumIntervalWithSTO +
                ", minimumIntervalWithSF=" + minimumIntervalWithSF +
                ", middleIntervalWithSTO=" + middleIntervalWithSTO +
                ", middleIntervalWithSF=" + middleIntervalWithSF +
                ", maximumIntervalWithSTO=" + maximumIntervalWithSTO +
                ", maximumIntervalWithSF=" + maximumIntervalWithSF +
                '}';
    }
}
