package com.bjpowernode.crm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    private String id;
    private String no;
    private String name;
    private String manager;
    private String description;
    private String phone;
}
