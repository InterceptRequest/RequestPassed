package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Value;

import java.io.Serializable;
import java.util.List;

public interface ValueService {
    List<Value> getAll();
    Value getId(Serializable id);
    int update(Value value);
    int delete(Serializable[]ids);
    int insert(Value value);

}
