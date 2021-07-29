package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Dept;

import java.io.Serializable;
import java.util.List;

public interface DeptService {
    List<Dept> getALl();
    Dept getId(Serializable id);
    int insert(Dept dept);
    int delete(Serializable... id);
    int update(Dept dept);
    void getOn (Serializable on);
}
