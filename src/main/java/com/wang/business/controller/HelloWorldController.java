package com.wang.business.controller;

import com.wang.business.model.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/springboot")
public class HelloWorldController {

    @Autowired
    One one;

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayWorld(@PathVariable("name") String name) {
        System.out.println("userName: " + one.getName());
        System.out.println("remark: " + one.getRemark());

        return "Hello " + name;
    }
}
