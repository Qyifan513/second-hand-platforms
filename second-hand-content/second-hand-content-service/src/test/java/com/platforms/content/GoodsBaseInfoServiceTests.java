package com.platforms.content;

import com.hand.content.model.dto.GoodsCategoryTreeDto;
import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.mapper.GoodsBaseMapper;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.content.service.GoodsCategoryService;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsBaseInfoServiceTests {
    @Autowired
    GoodsBaseService goodsBaseService;

    @Autowired
    GoodsBaseMapper goodsBaseMapper;

    @Autowired
    GoodsCategoryService goodsCategoryService;

    @Test
    void testGoodsBaseService() {
        QueryGoodsParamsDto queryGoodsParamsDto = new QueryGoodsParamsDto();
        queryGoodsParamsDto.setGoodsName("java");

        //分页参数
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(3L);

        PageResult<GoodsBase> goodsBasePageResult = goodsBaseService.queryGoodsBaseList(0L,pageParams, queryGoodsParamsDto);
        System.out.println(goodsBasePageResult);
    }
    @Test
    void testGoodsCategoryService() {
        System.out.println(goodsCategoryService.queryCategoryWithGoods("1"));
    }

    @Test
    public void findAll() {
        List<GoodsCategoryTreeDto> ans = goodsCategoryService.queryTreeNodes("1");
        ans.stream().forEach(item -> {
            System.out.print(item.getId());
//            item.getChildrenTreeNodes().stream().forEach(i -> System.out.println(i.getId()));
        });
        List<GoodsBase> list = goodsBaseService.searchByCategoryByMt("1-1");
        list.stream().forEach(item -> System.out.println(item.getId()));
//        System.out.println(ans);
    }
//    @Test void
}