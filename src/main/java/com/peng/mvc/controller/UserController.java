package com.peng.mvc.controller;

import com.peng.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*
    核心注解：@RequestMapping(value="", method={})
        扩展注解
            @GetMapping
            @PostMapping
            @PutMapping
            @DeleteMapping
    /user/info
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /*
        value/path（重点）：映射的url路径
        method（重点）：声明请求的方式，枚举支持的八大请求方式
        params（掌握）：指定请求参数的条件（就是请求地址中的 key=value，如果请求地址没有这个参数，那就直接报错）

     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    //@GetMapping("/list") // 等同于上面的 @RequestMapping
    @ResponseBody   // 加这个注解生成json数据，不让spring mvc自动去寻找默认的json数据，得自己在 spring-mvc.xml 文件自己配置
    public List<User> users(){
        return new ArrayList<>();
    }

    @GetMapping(value = "/info", params = "id=1")
    @ResponseBody
    public User user(int id){
        return new User();
    }

    // 只能接受json数据
    // 允许 post 请求
    // consumes 指定允许提交的内容类型
    @RequestMapping(value = "save", method = {RequestMethod.POST}, consumes = "application/json")
    @ResponseBody
    public String save(){
        return "";
    }

    // 即允许 post 又允许 get
    // produces 指定返回的内容类型
    @RequestMapping(value = "accept", method = {RequestMethod.POST}, produces = "img/png")
    @GetMapping
    @ResponseBody
    public String accept(){
        return "";
    }
}
