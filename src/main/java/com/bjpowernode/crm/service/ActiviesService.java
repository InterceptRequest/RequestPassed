package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Activities;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ActiviesService extends BaseService{
    List<Activities> get(Map map);

    List<Map> getAll();

    Map getId(Serializable id);

    int insert(Map map);

    int update(Map map);

    int delete(Serializable... ids);

    void insertList(List list);
}
