package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.TabUser;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    TabUser getUser(String loginAct, String loginPwd, String ip);

    TabUser User(String loginAct, String loginPwd, String ip);

    List<String> getOwner();

   // void updateUser(String oldPwd, String newPwd, HttpSession httpSession);
}
