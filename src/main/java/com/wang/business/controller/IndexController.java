package com.wang.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyongwei on 2017/8/17.
 */
@RestController
@RequestMapping("test")
@Api(value="测试类", tags="测试接口")
public class IndexController {

    @RequestMapping(value = "index")
    @ApiOperation("测试读写分离")
    public String index() {
        return "Hello World!!";
    }
}

