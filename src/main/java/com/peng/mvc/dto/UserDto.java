package com.peng.mvc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private int id;
    private String username;
    private AddressDto addressDto;  // 传入对象
    private List<String> list;      // 传入 list 集合
}
