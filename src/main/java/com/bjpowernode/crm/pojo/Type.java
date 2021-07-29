package com.bjpowernode.crm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Type implements Serializable {
    private String code;
    private String name;
    private String description;


}
