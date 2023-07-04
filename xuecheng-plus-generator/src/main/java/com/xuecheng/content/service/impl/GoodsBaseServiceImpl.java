package com.xuecheng.content.service.impl;

import com.xuecheng.content.model.po.GoodsBase;
import com.xuecheng.content.mapper.GoodsBaseMapper;
import com.xuecheng.content.service.GoodsBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 课程基本信息 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class GoodsBaseServiceImpl extends ServiceImpl<GoodsBaseMapper, GoodsBase> implements GoodsBaseService {

}
