package com.platforms.content;

import com.hand.content.model.GoodsBase;
import com.hand.content.model.dto.QueryCourseParamsDto;
import com.platforms.secondhandbase.PageParams;
import com.platforms.secondhandbase.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class GoodsBaseInfoController {
    @RequestMapping("/course/list")
    public PageResult<GoodsBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParams){

        return null;

    }

}