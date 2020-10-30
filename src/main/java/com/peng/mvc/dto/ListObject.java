package com.peng.mvc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ListObject implements Serializable {
    private List<String> list;
}
