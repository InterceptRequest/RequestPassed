package com.bjpowernode.crm.pojo;

import lombok.Data;

@Data
public class Activities {
    private String id;
    private String owner;
    private String name;
    private String startDate;
    private String endDate;
    private String cost;
    private String description;
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
}
