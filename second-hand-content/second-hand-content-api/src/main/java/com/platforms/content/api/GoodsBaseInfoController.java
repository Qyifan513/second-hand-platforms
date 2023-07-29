package com.platforms.content.api;


import com.hand.content.model.dto.QueryGoodsParamsDto;
import com.hand.content.model.dto.SaveGoodsBaseDto;
import com.hand.content.model.dto.SubCategoryParams;
import com.hand.content.model.po.GoodsBase;
import com.platforms.content.service.GoodsBaseService;
import com.platforms.content.util.SecurityUtil;
import com.platforms.secondhandbase.MyResult;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoodsBaseInfoController {
    @Autowired
    GoodsBaseService goodsBaseService;

//    @PreAuthorize("hasRole('user')")
    @PostMapping("/goods/list")
    public PageResult<GoodsBase> list(PageParams pageParams, @RequestBody(required = false) QueryGoodsParamsDto queryCourseParams) {
        PageResult<GoodsBase> result = null;
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        System.out.println("当前用户身份为：" + user);
        long school = 0L;
        if (StringUtils.isNotEmpty(user.getSchoolId())) {
        school = Long.parseLong(user.getSchoolId());
        }
        result = goodsBaseService.queryGoodsBaseList(school,pageParams, queryCourseParams);
        return result;
    }

//    @PreAuthorize("hasRole('user')")
    @GetMapping("/goods/load")
    public MyResult<GoodsBase> load(){
        MyResult<GoodsBase> result = null;
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        System.out.println("当前用户身份为：" + user);
        long schoolId = 0L;
        if (StringUtils.isNotEmpty(user.getSchoolId())) {
            schoolId = Long.parseLong(user.getSchoolId());
        }
        result = goodsBaseService.load(schoolId);
        return result;
    }

    @PostMapping("/category/goods/temporary")
    public PageResult<GoodsBase> querytemporary(@RequestBody SubCategoryParams param){
        PageResult<GoodsBase> result = null;
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        System.out.println("当前用户身份为：" + user);
        long school = 0L;
        if (StringUtils.isNotEmpty(user.getSchoolId())) {
            school = Long.parseLong(user.getSchoolId());
        }
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(param.getPage());
        pageParams.setPageSize(param.getPageSize());
        QueryGoodsParamsDto queryGoodsParamsDto = new QueryGoodsParamsDto();
        queryGoodsParamsDto.setCategoryId(param.getCategoryId());
        result = goodsBaseService.queryGoodsBaseList(school,pageParams, queryGoodsParamsDto);
        return result;
    }
    @PreAuthorize("hasRole('user')")
    @PostMapping("/r/getuser")
    public Object myget(){
        return SecurityUtil.getUser();
    }
    /**
     * 新增商品
     * @param saveGoodsBaseDto
     * @return
     */
    @PostMapping("/save")
    public MyResult<String> save(@RequestBody SaveGoodsBaseDto saveGoodsBaseDto){
        //添加filename

        return null;
    }
}