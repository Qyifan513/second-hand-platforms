package com.platforms.content.service.impl;


import com.hand.content.model.dto.CategoryWithGoods;
import com.hand.content.model.dto.GoodsCategoryTreeDto;
import com.platforms.content.mapper.GoodsCategoryMapper;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.content.service.GoodsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<CategoryWithGoods> queryCategoryWithGoods(String id){
        List<GoodsCategoryTreeDto> temp = queryTreeNodes(id);
        List<CategoryWithGoods> categoryWithGoods = new ArrayList<>();
        temp.stream().forEach(item -> {
            CategoryWithGoods categoryWithGoods1 = new CategoryWithGoods(item);
            //获取goods
            categoryWithGoods1.setGoods(goodsBaseService.searchByCategoryByMt(item.getId()));
            //
            categoryWithGoods.add(categoryWithGoods1);
        });
        return categoryWithGoods;
    }

    @Override
    public List<GoodsCategoryTreeDto> selectTreeNodesById(String id){
        return goodsCategoryMapper.selectTreeNodes(id);
    }
}
