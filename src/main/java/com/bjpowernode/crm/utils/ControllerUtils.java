package com.bjpowernode.crm.utils;


import com.bjpowernode.crm.pojo.TabUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ControllerUtils {
    public static void initSave(Object o, HttpSession session) {
        try {
            TabUser user = (TabUser)session.getAttribute("LoginAct");
            String createBy = user.getLoginAct() + "|" + user.getName();
            String createTime = DateTimeUtil.getSysTime();
            BeanUtils.setProperty(o, "id", UUIDUtil.getUUID());
            BeanUtils.setProperty(o, "createBy", createBy);
            BeanUtils.setProperty(o, "createTime", createTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
    public static void initSaveMap(Map data, HttpSession session) {

            TabUser user = (TabUser)session.getAttribute("LoginAct");
            String createBy = user.getLoginAct() + "|" + user.getName();
            String createTime = DateTimeUtil.getSysTime();
            data.put("id", UUIDUtil.getUUID());
            data.put("createBy", createBy);
            data.put("createTime", createTime);

    }

    public static void initUpdate(Map data, HttpSession session) {
        TabUser user = (TabUser)session.getAttribute("LoginAct");
        String editBy = user.getLoginAct() + "|" + user.getName();
        String editTime = DateTimeUtil.getSysTime();
        data.put("editBy", editBy);
        data.put("editTime", editTime);
    }
}
