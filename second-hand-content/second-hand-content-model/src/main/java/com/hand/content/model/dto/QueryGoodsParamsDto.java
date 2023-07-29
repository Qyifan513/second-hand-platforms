package com.hand.content.model.dto;

import lombok.Data;
import lombok.ToString;
/**
 * @author Mr.M
 * @version 1.0
 * @description 商品查询条件模型类
 * @date 2023/2/11 15:37
 */
@Data
@ToString
public class QueryGoodsParamsDto {
    public String getAuditStatus() {
        return auditStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    //审核状态
    private String auditStatus;

    //商品名称
    private String goodsName;
    //状态
    private String status;
    //分类id
    private String categoryId;
}
