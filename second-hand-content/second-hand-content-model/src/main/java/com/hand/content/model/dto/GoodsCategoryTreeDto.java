package com.hand.content.model.dto;

import com.hand.content.model.po.GoodsCategory;
import lombok.Data;

import java.util.List;

@Data
public class GoodsCategoryTreeDto extends GoodsCategory implements java.io.Serializable{
    //子节点
    private List<GoodsCategoryTreeDto> childrenTreeNodes;

    public GoodsCategoryTreeDto(GoodsCategoryTreeDto dto) {
        this.setId(dto.getId());
        this.setIsLeaf(dto.getIsLeaf());
        this.setIsShow(dto.getIsShow());
        this.setLabel(dto.getLabel());
        this.setName(dto.getName());
        this.setOrderby(dto.getOrderby());
        this.setParentid(dto.getParentid());
        this.setChildrenTreeNodes(dto.getChildrenTreeNodes());
        this.setPicture(dto.getPicture());
    }

    public List<GoodsCategoryTreeDto> getChildrenTreeNodes() {
        return childrenTreeNodes;
    }

    public void setChildrenTreeNodes(List<GoodsCategoryTreeDto> childrenTreeNodes) {
        this.childrenTreeNodes = childrenTreeNodes;
    }

    public GoodsCategoryTreeDto() {
        this.childrenTreeNodes = null;
    }
}
