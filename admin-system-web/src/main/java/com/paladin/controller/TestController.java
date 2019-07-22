package com.paladin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/7/22 13:48
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test/something")
    public String getSomething(){
        return "200";
    }

}
