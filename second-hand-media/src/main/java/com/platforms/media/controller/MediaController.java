package com.platforms.media.controller;


import com.alibaba.fastjson.JSONObject;
import com.platforms.media.service.MediaService;
import com.platforms.secondhandbase.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 媒资信息 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
public class MediaController {

    @Autowired
    private MediaService  mediaService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public MyResult<String> updateByNameforGoods(@RequestBody HashMap<String, Object> map){
        MyResult<String> stringMyResult = new MyResult<>();
        Object tmp = map.get("goods_id");
        String updateGoods = tmp.toString();
        List list = (List) map.get("imagelist");
//        list.stream().forEach(filename ->{
//            mediaService.updateByNameforGoods((String) filename,updateGoods);
//        });
        mediaService.updateByNamesforGoods(list,updateGoods);
        stringMyResult.setMsg("更新成功");
        return stringMyResult;
    }
}
