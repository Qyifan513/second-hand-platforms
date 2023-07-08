package com.platforms.content.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.mapper.GoodsBaseMapper;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.secondhandbase.MyResult;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品基本信息 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class GoodsBaseServiceImpl implements GoodsBaseService {
    @Autowired
    GoodsBaseMapper goodsBaseMapper;

    @Override
    public PageResult<GoodsBase> queryCourseBaseList(PageParams pageParams, QueryGoodsParamsDto goodsParamsDto){
        //拼装查询条件
        LambdaQueryWrapper<GoodsBase> queryWrapper = new LambdaQueryWrapper<>();
        //根据名称模糊查询,在sql中拼接 course_base.name like '%值%'
        queryWrapper.like(StringUtils.isNoneEmpty(goodsParamsDto.getGoodsName()),GoodsBase::getName,goodsParamsDto.getGoodsName());
        //创建page分页参数对象，参数：当前页码，每页记录数
        Page<GoodsBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<GoodsBase> pageResult = goodsBaseMapper.selectPage(page, queryWrapper);
        //数据列表
        List<GoodsBase> items = pageResult.getRecords();
        //总记录数
        long total = pageResult.getTotal();
        PageResult<GoodsBase> goodsBasePageResult = new PageResult<GoodsBase>(items, total, pageParams.getPageNo(),pageParams.getPageSize());
        return goodsBasePageResult;
    }

    @Override
    public MyResult<GoodsBase> load() {
        MyResult<GoodsBase> goodsBaseMyResult = new MyResult<>();
        goodsBaseMyResult.setResult(goodsBaseMapper.selectList(null));
        goodsBaseMyResult.setCode("1");
        goodsBaseMyResult.setMsg("操作成功");
        return goodsBaseMyResult;
    }

}
