package com.bjpowernode.crm.pojo;

import lombok.Data;

@Data
public class Tran {
    private String id;
    private String owner;
    private String amountOfMoney;
    private String name;
    private String expectedClosingDate;
    private String customerId;
    private String stage;
    private String type;
    private String source;
    private String activityId;
    private String contactsId;
    private String description;
    private String createTime;
    private String createBy;
    private String editBy;
    private String editTime;
    private String contactSummary;
    private String nextContactTime;

    private Customer customer;
    private Activities activities;
    private Contacts contacts;
}
