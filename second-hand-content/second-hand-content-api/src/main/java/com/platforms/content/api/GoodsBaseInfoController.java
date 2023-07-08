package com.platforms.content.api;


import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.secondhandbase.MyResult;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsBaseInfoController {
    @Autowired
    GoodsBaseService goodsBaseService;

    @PostMapping("/goods/list")
    public PageResult<GoodsBase> list(PageParams pageParams, @RequestBody(required=false) QueryGoodsParamsDto queryCourseParams){
        return goodsBaseService.queryCourseBaseList(pageParams,queryCourseParams);
    }
    @GetMapping("/goods/load")
    public MyResult<GoodsBase> load(){
        return goodsBaseService.load();
    }
}