package com.peng.mvc.controller;

import com.peng.mvc.dto.ResponseEntity;
import com.peng.mvc.entity.User;
import com.peng.mvc.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 微服务
 * <p>
 * REST  定义路径  路径尽量使用名词
 * api/v1/user/list?page=1&size=2   get  获取数据
 * api/v1/user/list/1/10
 * api/v1/user/login/
 * api/v1/user/register/
 *
 * 移动
 * 前段 + 后台  + 数据 +  部署
 * 后台 + 前段   +  ios+安卓 +前端
 *
 * RPC dubbo
 * REST 微服务  spring cloud
 *
 * 前后端不分离  @Controller  +  @ResponseBody
 * 给移动端开发的时候
 *
 * @RestController  前后端分离的注解    （@RestController = @Controller + @ResponseBody）
 */
@RestController
public class ResponseController {

    @Resource
    UserService userService;

    /*
        路径传参有两种方式：?和动态

            @PathVariable：动态路劲
     */
    // api/detail/id的值
    @GetMapping("/detail/{id}")
    public User details(@PathVariable int id){
        System.out.println(id);
        return new User();
    }

    // api/list/page值/size值 （ api/list/5/8 ）
    @GetMapping("/list/{page}/{size}")
    public String list(@PathVariable int page, @PathVariable int size){
        System.out.println(page);
        System.out.println(size);
        return "@PathVariable 动态路径";
    }

    @GetMapping("/re/{id}")
    public ResponseEntity<User> re(@PathVariable int id){
        ResponseEntity<User> ure = new ResponseEntity<>();
        ure.setData(new User());
        return ure;
    }
}
