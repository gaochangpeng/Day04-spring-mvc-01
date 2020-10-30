package com.peng.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

// 认证 jwt（RequestHeader：该注解是请求头传递参数，以后在头部认证）
@Controller
public class RequestHeaderController {

    @GetMapping("/h1")
    @ResponseBody
    public String head(@RequestHeader String token){
        System.out.println(token);
        return "RequestHeader 注解，请求头传递参数";
    }

    @GetMapping("/c1")
    @ResponseBody
    public String cookie(@CookieValue("UM_DISTINCTID")String um){
        System.out.println(um);
        return "CookieValue 注解";
    }
}
