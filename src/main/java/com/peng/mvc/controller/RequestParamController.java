package com.peng.mvc.controller;

import com.peng.mvc.dto.UserRequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestParamController {

    @GetMapping("/t1")
    @ResponseBody
    public String test1(@RequestParam(value = "user_name", required = false) String username){
        System.out.println(username);
        return "requestParam注解的value可以起到别名的作用";
    }

    /*
        @RequestParam()     // 请求参数
            属性：
                value：当客户端的参数跟方法的参数不一致的时候可以使用（也就是可以做到起别名的作用）
                required：是否为必要参数（默认为true）
                defaultValue：给参数赋默认值
     */
    @PostMapping("/t2")
    @ResponseBody
    public String test2(@RequestParam(value = "username", required = false) String name,
                        @RequestParam(required = false, defaultValue = "5") int page,
                        @RequestParam(required = false, defaultValue = "8") int size)
    {
        System.out.println(name);
        System.out.println(page);
        System.out.println(size);
        return "RequestParam 注解的使用";
    }

    // 传递参数不要使用map 尽量使用对象
    @PostMapping("/t3")  // 因为get请求没有请求体，所以得要用post请求
    @ResponseBody
    public String test3(@RequestBody UserRequestParam param){
        System.out.println(param.toString());
        return "RequestBody 注解，请求体传递参数";
    }
}
