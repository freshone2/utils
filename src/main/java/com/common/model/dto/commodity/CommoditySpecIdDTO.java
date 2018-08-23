package com.common.model.dto.commodity;

import java.io.Serializable;

public class CommoditySpecIdDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer specId;
	private Integer commodityId;
	private String specNo;
	private String commodityNo;
	
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public Integer getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}
	public String getSpecNo() {
		return specNo;
	}
	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}
	public String getCommodityNo() {
		return commodityNo;
	}
	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}
}
