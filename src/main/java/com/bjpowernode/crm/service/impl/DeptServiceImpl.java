package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.mapper.DataMapper;
import com.bjpowernode.crm.pojo.Dept;
import com.bjpowernode.crm.service.DeptService;
import javafx.fxml.LoadException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    DataMapper dataMapper;

    @Override
    public List<Dept> getALl() {
        return dataMapper.getALl();
    }

    @Override
    public Dept getId(Serializable id) {

        return dataMapper.getId(id);
    }

    @Override
    public int insert(Dept dept) {
        return dataMapper.insert(dept);
    }

    @Override
    public int delete(Serializable... id) {
        return dataMapper.delete(id);
    }

    @Override
    public int update(Dept dept) {

        return dataMapper.update(dept);
    }

    @Override
    public void getOn(Serializable on) {
        if(dataMapper.getOn(on)){
            throw new LoginException("编号重复！");
        }
    }

}
