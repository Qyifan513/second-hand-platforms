package com.hand.content.model.dto;

import com.hand.content.model.po.GoodsBase;

import java.util.List;

public class CategoryWithGoods extends GoodsCategoryTreeDto{
    private List<GoodsBase> goods;

    public CategoryWithGoods(List<GoodsBase> goods) {
        this.goods = goods;
    }

    public CategoryWithGoods() {
        this.goods = null;
    }
    public CategoryWithGoods(GoodsCategoryTreeDto dto){
        super(dto);
        this.goods = null;
    }

    public List<GoodsBase> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBase> goods) {
        this.goods = goods;
    }
}
