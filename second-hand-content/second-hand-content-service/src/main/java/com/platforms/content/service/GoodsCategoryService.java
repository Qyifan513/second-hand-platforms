package com.platforms.content.service;


import com.hand.content.model.dto.CategoryWithGoods;
import com.hand.content.model.dto.GoodsCategoryTreeDto;

import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-07-08
 */
public interface GoodsCategoryService{
    List<GoodsCategoryTreeDto> selectTreeNodesById(String id);
    /**
     * 商品分类树形结构查询
     *
     * @return
     */
    List<GoodsCategoryTreeDto> queryTreeNodes(String id);

    /**
     * 带商品信息的分类查询
     *
     * @return
     */
    List<CategoryWithGoods> queryCategoryWithGoods(String id);

}
