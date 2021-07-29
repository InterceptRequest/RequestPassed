package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.mapper.TypeMapper;
import com.bjpowernode.crm.mapper.ValueMapper;
import com.bjpowernode.crm.pojo.Type;
import com.bjpowernode.crm.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    TypeMapper typeMapper;

    @Resource
    ValueMapper valueMapper;
    @Override
    public boolean codeVerification(Serializable code) {
        return typeMapper.codeVerification(code);
    }

    @Override
    public void addType(Type type) {
        typeMapper.addType(type);
    }

    @Override
    public List<Type> getAll() {
        return typeMapper.getAll();
    }

    @Override
    public void delete(Serializable[] ids) {
        typeMapper.delete(ids);
    }

    @Override
    public Type getId(Serializable code) {

        return typeMapper.getId(code);
    }

    @Override
    public void update(Type type) {
        typeMapper.update(type);
    }

    @Override
    public List<String> getUsed(Serializable... ids) {
        return valueMapper.getUsed(ids);
    }
}
