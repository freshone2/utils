package com.common.model.bo.commodity;

/**
 * @Package: com.common.model.bo.commodity
 * @Description:
 * @author: jklofs
 * @date: 2018/7/10 下午3:57
 */
public class RelationCommodityBo extends CommodityBo {
    private Integer relationNum;

    public Integer getRelationNum() {
        return relationNum;
    }

    public void setRelationNum(Integer relationNum) {
        this.relationNum = relationNum;
    }

    @Override
    public String toString() {
        return "RelationCommodityBo{" +
                "super = " + super.toString() +
                "relationNum=" + relationNum +
                '}';
    }
}
