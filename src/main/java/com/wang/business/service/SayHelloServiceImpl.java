package com.wang.business.service;

/**
 * Created by wangyongwei on 2018/1/4.
 */
public class SayHelloServiceImpl implements SayHelloService {

    public String sayHello(String helloArg) {
        if (helloArg.equals("hello")) {
            return "hello";
        } else {
            return "bye bye";
        }
    }
}
