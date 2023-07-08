package com.platforms.content;

import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.mapper.GoodsBaseMapper;
import com.platforms.content.service.GoodsBaseService;
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
    @Test
    void testGoodsBaseService(){
        QueryGoodsParamsDto queryGoodsParamsDto = new QueryGoodsParamsDto();
        queryGoodsParamsDto.setGoodsName("java");

        //分页参数
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(3L);

        PageResult<GoodsBase> goodsBasePageResult = goodsBaseService.queryCourseBaseList(pageParams, queryGoodsParamsDto);
        System.out.println(goodsBasePageResult);
    }
    @Test
    public void findAll() {
        List<GoodsBase> users = goodsBaseMapper.selectList(null);
        System.out.println(users);
    }
}
