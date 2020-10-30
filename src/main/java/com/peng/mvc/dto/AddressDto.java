package com.peng.mvc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private int id;
    private String city;
}
