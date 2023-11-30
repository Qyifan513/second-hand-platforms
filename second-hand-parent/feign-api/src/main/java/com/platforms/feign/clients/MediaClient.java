package com.platforms.feign.clients;


import com.platforms.secondhandbase.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@FeignClient(value = "media-service")
public interface MediaClient {
    //修改image信息
    @RequestMapping(value = "/media/update", method = RequestMethod.POST)
    MyResult<String> updateMeidaforGoods(@RequestBody HashMap<String, Object> map);
}
