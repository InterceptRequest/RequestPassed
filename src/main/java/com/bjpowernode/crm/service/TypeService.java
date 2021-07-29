package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Type;

import java.io.Serializable;
import java.util.List;

public interface TypeService {
    boolean codeVerification(Serializable code);

    void addType(Type type);

    List<Type> getAll();

    void delete(Serializable[]ids);
    Type getId(Serializable code);
    void update(Type type);
    List<String> getUsed(Serializable... ids);

}
