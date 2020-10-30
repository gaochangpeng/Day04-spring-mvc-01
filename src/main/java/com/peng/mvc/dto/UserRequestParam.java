package com.peng.mvc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserRequestParam implements Serializable {
    private int age;
    private String name;
    private List<AddressDto> addressDto;
}
