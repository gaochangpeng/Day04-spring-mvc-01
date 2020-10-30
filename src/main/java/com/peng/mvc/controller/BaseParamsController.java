package com.peng.mvc.controller;

import com.peng.mvc.dto.AddressDto;
import com.peng.mvc.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 如何接收参数
 *
 * 1> 接受基本类型的参数
 * 2> 对象(简单对象 复杂对象)
 * 3> map 数组  集合(list)
 * 4> 日期
 */

@Controller
public class BaseParamsController {

    // xxx/test1?username="11111"
    // 接收 基本类型的参数
    @GetMapping("/test1")
    @ResponseBody
    public String test1(int id, String username){
        System.out.println(id);
        System.out.println(username);
        return username;
    }

    // 接收 对象参数形式（简单对象）
    @GetMapping("/test2")
    @ResponseBody
    public String test2(AddressDto addressDto){
        System.out.println(addressDto);
        return "接收 简单对象 参数形式";
    }

    // 接收 对象参数形式（复杂对象）
    @GetMapping("/test3")
    @ResponseBody
    public String test3(UserDto userDto){
        System.out.println(userDto);
        System.out.println(userDto.getAddressDto().getCity());
        return "接收 复杂对象 参数形式";
    }

    // 接收 map集合 类型参数
    @GetMapping("/test4")
    @ResponseBody
    public String test4(Map<String,String> map){
        System.out.println(map.toString());
        return "接收 map集合 类型参数";
    }

    // 接收数组类型的参数
    @GetMapping("/test5")
    @ResponseBody
    public String test5(int[] ids){
        System.out.println(ids);
        return "接收 数组 类型参数";
    }

    // 接收 list集合 类型参数（不能单独用list集合，这样会报错的，必须结合 @RequestParam() 注解使用）
    @GetMapping("/test6")
    @ResponseBody
    public String test6(UserDto userDto){
        System.out.println(userDto.getList().toString());
        return "接收 list集合 类型参数";
    }

    // 接收 内置对象 类型参数
    @GetMapping("/test7")
    @ResponseBody
    public String test7(HttpServletRequest request,
                    HttpServletResponse response,
                    HttpSession session,
                    Model model,
                    ModelMap modelMap)
    {
        System.out.println(request.toString());
        System.out.println(response.toString());
        return "接收 内置对象 参数";
    }
}
