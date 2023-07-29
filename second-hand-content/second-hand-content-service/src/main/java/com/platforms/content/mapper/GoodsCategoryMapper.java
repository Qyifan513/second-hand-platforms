package com.platforms.content.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hand.content.model.dto.GoodsCategoryTreeDto;
import com.hand.content.model.po.GoodsCategory;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {
    /**
     * 从分类id为id的记录开始递归查询，返回递归查询结果
     *id 分类id
     */
    List<GoodsCategoryTreeDto> selectTreeNodes(String id);

}
