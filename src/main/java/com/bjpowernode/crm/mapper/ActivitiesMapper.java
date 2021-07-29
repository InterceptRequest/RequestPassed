package com.bjpowernode.crm.mapper;

import com.bjpowernode.crm.pojo.Activities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ActivitiesMapper {
    List<Activities> get(Map map);

    void insertList(List list);

    List getActivities(Serializable clued);
}
