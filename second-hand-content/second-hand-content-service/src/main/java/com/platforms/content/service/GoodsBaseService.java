package com.platforms.content.service;


import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.secondhandbase.MyResult;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;

import java.util.List;

/**
 * <p>
 * 课程基本信息 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-07-08
 */
public interface GoodsBaseService {
    /**
     * 商品分页查询
     * @param pageParams 分页查询参数
     * @param goodsParamsDto 查询条件
     * @return 查询结果
     */
    public PageResult<GoodsBase> queryGoodsBaseList(long school, PageParams pageParams, QueryGoodsParamsDto goodsParamsDto);
    /**
     * 商品查询，查询所有商品记录
     * @return 查询结果
     */
    public MyResult<GoodsBase> load(long school);

    public List<GoodsBase> searchByCategoryByMt(String mt);
}
