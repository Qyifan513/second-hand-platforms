package com.platforms.content.api;

import com.hand.content.model.dto.CategoryWithGoods;

import com.hand.content.model.dto.GoodsCategoryTreeDto;
import com.hand.content.model.dto.SubCategoryParams;
import com.platforms.content.service.GoodsCategoryService;
import com.platforms.secondhandbase.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsCategoryController {
    @Autowired
    GoodsCategoryService goodsCategoryService;

    @GetMapping("/catrgory/goods")
    public List<CategoryWithGoods> querygoods(){
        return goodsCategoryService.queryCategoryWithGoods("1");
    }

    @GetMapping("/catrgory/{id}")
    public List<GoodsCategoryTreeDto> querycatrgory(@PathVariable("id") String id) {
        List<GoodsCategoryTreeDto> goodsCategoryTreeDtos = goodsCategoryService.selectTreeNodesById(id);
        return goodsCategoryTreeDtos;
    }
    @GetMapping("/catrgory/withgoods/{id}")
    public List<CategoryWithGoods> querygoods(@PathVariable("id") String id){
        return goodsCategoryService.queryCategoryWithGoods(id);
    }
}

