package com.peng.mvc.dto;

import lombok.Data;

@Data
public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T data;
}
