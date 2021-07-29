package com.bjpowernode.crm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Value implements Serializable {
       private  String id;
       private  String value;
       private  String text;
       private  String orderNo;
       private  String typeCode;
}
