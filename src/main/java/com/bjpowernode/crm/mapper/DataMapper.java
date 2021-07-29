package com.bjpowernode.crm.mapper;

import com.bjpowernode.crm.pojo.Dept;

import java.io.Serializable;
import java.util.List;

public interface DataMapper {
    List<Dept> getALl();
    Dept getId(Serializable id);
    int insert(Dept dept);
    int delete(Serializable... id);
    int update(Dept dept);
    boolean getOn (Serializable on);
}
