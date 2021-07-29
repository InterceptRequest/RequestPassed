package com.bjpowernode.crm.mapper;

import com.bjpowernode.crm.pojo.TabUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    TabUser getUser(@Param("loginAct") String loginAct,
                      @Param("loginPwd") String loginPwd);

    List<String> getOwner();
}
