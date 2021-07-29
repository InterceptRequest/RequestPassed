package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.mapper.ActivitiesMapper;
import com.bjpowernode.crm.mapper.CommonsMapper;
import com.bjpowernode.crm.pojo.Activities;
import com.bjpowernode.crm.service.ActiviesService;
import com.bjpowernode.crm.utils.ControllerUtils;
import com.bjpowernode.crm.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Service
public class ActiviesServiceImpl implements ActiviesService{
    @Resource
    ActivitiesMapper activitiesMapper;

    @Resource
    CommonsMapper commonsMapper;

    @Override
    public List<Activities> get(Map map) {
        List<Activities> activities = activitiesMapper.get(map);

        if(activities.size() == 0){
            throw new LoginException("找不到数据!");
        }
        return activities;
    }

    @Override
    public List<Map> getAll() {
        return commonsMapper.getAll(TABLE.ATS);
    }

    @Override
    public Map getId( Serializable id) {
        return commonsMapper.getId(TABLE.ATS,id);
    }

    @Override
    public int insert( Map map) {
        return commonsMapper.insert(TABLE.ATS,map);
    }

    @Override
    public int update( Map map) {
        return commonsMapper.update(TABLE.ATS,map);
    }

    @Override
    public int delete(Serializable... ids) {
        return commonsMapper.delete(TABLE.ATS,ids);
    }

    @Override
    public void insertList(List list) {
        activitiesMapper.insertList(list);
    }


}
