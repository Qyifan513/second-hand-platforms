package com.platforms.content.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hand.content.model.po.GoodsBase;
import com.hand.content.model.po.School;
import com.platforms.content.mapper.SchoolMapper;

import com.platforms.content.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService{

    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public Long getSchoolId(JSONObject param) {
        String school = param.getString("school");
        //添加学校id
        //拼装查询条件
        LambdaQueryWrapper<School> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(school),School::getName,school);
        return (Long) super.getMap(queryWrapper).get("id");
    }
}
