package com.platforms.content.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hand.content.model.po.GoodsBase;
import com.hand.content.model.po.School;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-08-22
 */
public interface SchoolService extends IService<School> {

//    void getMap(LambdaQueryWrapper<GoodsBase> queryWrapper);
Long getSchoolId(JSONObject param);
}
