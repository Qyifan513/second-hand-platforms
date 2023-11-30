package com.platforms.content.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hand.content.model.dto.CategoryWithGoods;
import com.hand.content.model.dto.GoodsCategoryTreeDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.mapper.GoodsBaseMapper;
import com.platforms.content.mapper.GoodsCategoryMapper;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.content.service.GoodsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.platforms.content.util.SecurityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    GoodsBaseMapper goodsBaseMapper;

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    GoodsBaseService goodsBaseService;

    @Override
    public List<GoodsCategoryTreeDto> queryTreeNodes(String id) {
        //查询分类信息
        List<GoodsCategoryTreeDto> goodsCategoryTreeDtos = goodsCategoryMapper.selectTreeNodes(id);
        Map<String,GoodsCategoryTreeDto> mapTemp = goodsCategoryTreeDtos.stream().filter(item -> !id.equals(item.getId())).collect(Collectors.toMap(key -> key.getId(), value -> value,(key1,key2) -> key2));
        //定义一个list作为最终返回的list
        List<GoodsCategoryTreeDto> goodsCategoryTreeDtoList = new ArrayList<>();
        goodsCategoryTreeDtos.stream().filter(item -> !id.equals(item.getId())).forEach(item ->{
            if(item.getParentid().equals(id)){
                goodsCategoryTreeDtoList.add(item);
            }else {
                GoodsCategoryTreeDto goodsCategoryParent = mapTemp.get(item.getParentid());
                if(goodsCategoryParent.getChildrenTreeNodes() == null){
                    goodsCategoryParent.setChildrenTreeNodes(new ArrayList<GoodsCategoryTreeDto>());
                }
                goodsCategoryParent.getChildrenTreeNodes().add(item);
            }
        });
        return goodsCategoryTreeDtoList;
    }
    @Override
    public List<CategoryWithGoods> queryCategoryWithGoods(long school, String id){
        List<GoodsCategoryTreeDto> temp = queryTreeNodes(id);
        List<CategoryWithGoods> categoryWithGoods = temp.stream()
                .map(item -> {
                    CategoryWithGoods categoryWithGoods1 = new CategoryWithGoods(item);
                    LambdaQueryWrapper<GoodsBase> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(StringUtils.isNotEmpty(item.getId()), GoodsBase::getSt, item.getId());
                    queryWrapper.eq(GoodsBase::getSchoolId,school);
                    queryWrapper.last("limit 8");
                    categoryWithGoods1.setGoods(goodsBaseMapper.selectList(queryWrapper));
                    return categoryWithGoods1;
                })
                .collect(Collectors.toList());
        return categoryWithGoods;
    }

    @Override
    public List<GoodsCategoryTreeDto> selectTreeNodesById(String id){
        return goodsCategoryMapper.selectTreeNodes(id);
    }
}
