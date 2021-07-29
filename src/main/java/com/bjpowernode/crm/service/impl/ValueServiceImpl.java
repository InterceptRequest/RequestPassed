package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.mapper.ValueMapper;
import com.bjpowernode.crm.pojo.Value;
import com.bjpowernode.crm.service.ValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service
public class ValueServiceImpl implements ValueService {
    @Resource
    ValueMapper valueMapper;
    @Override
    public List<Value> getAll() {

        return valueMapper.getAll();
    }

    @Override
    public Value getId(Serializable id) {

        return valueMapper.getId(id);
    }

    @Override
    public int update(Value value) {
        return valueMapper.update(value);
    }

    @Override
    public int delete(Serializable[]ids) {
        return valueMapper.delete(ids);
    }

    @Override
    public int insert(Value value) {
        return valueMapper.insert(value);
    }
}
