package com.bjpowernode.crm.mapper;

import com.bjpowernode.crm.pojo.Type;

import java.io.Serializable;
import java.util.List;

public interface TypeMapper {
    boolean codeVerification(Serializable code);

    void addType(Type type);

    List<Type> getAll();

    void delete(Serializable[]ids);
    Type getId(Serializable code);

    void update(Type type);


}
