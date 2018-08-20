package com.common.model.dto.jgj.product;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class ProductInfoRequestDTO extends RequestDTO {

    @Data
    public static class ProductInfoDTO{

        //二级来源类型
        private String subSource="02";

        //唯一ID(长度最大为12位的字母和数字),需与<保存预付单>接口和<订单 回传接口>接口中commodityID字段 保持一致
        private String productId;

        //产品名称
        private String productName;

        //产品描述 可选
        private String productDescription;

        //产品售卖价格(以分为单位)
        private String productPrice;

        //产品原价(以分为单位) 可选
        private String productOriginalPrice;

        //产品图片URL(外网可访问)
        private String productImgUrl;

        //产品详情地址URL(外网可访问)
        private String productDetailUrl;

        //产品关键词(最少1个，最多5个)(方 便用户能更好搜索到) 可选
        private List<String> productKeywords;

        //U:新增/更新 D:删除
        private String operateType;

        //产品销量 可选
        private String productSales;

        //商店名称 可选
        private String storeName;

        //人气/评价标签 可选
        private String hotLabel;

        //数据一级类别id
        private String category;

        //数据二级类别id
        private String subCategory;

        //商品spu
        private String spu;

        //商品sku
        private String sku;

        //作者 可选
        private String author;

        //二级来源分类名称 可选
        private String subSourceName;

        //销售标签.展示在列表中，目前只限3 个，每个标签不多于6个字 可选
        private List<String> salesLabel;

    }

    //商户ID(商户唯一ID)
    private String appId;

    //签名
    private String securitySign;

    //来源分类
    private String source="02";

    //产品信息列表
    private List<ProductInfoDTO> productInfoList;

}
