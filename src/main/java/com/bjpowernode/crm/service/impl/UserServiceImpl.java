package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.mapper.UserMapper;
import com.bjpowernode.crm.pojo.TabUser;
import com.bjpowernode.crm.service.UserService;
import com.bjpowernode.crm.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;



    @Override
    public TabUser getUser(String loginAct, String loginPwd, String ip)  {
        TabUser user = userMapper.getUser(loginAct, MD5Util.getMD5(loginPwd));

        //验证账号密码
        if(user==null) throw new LoginException("账号或密码错误，请重新输入！");


        //失效时间
        try {
            long endTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(user.getExpireTime()).getTime();

            long time = System.currentTimeMillis();

            if(time>endTime) throw new LoginException("账号已过期!");

        } catch (ParseException e) {
            throw new LoginException("账号被冻结！");
        }

        //锁定状态
        if("0".equals(user.getLockStatus())) throw new LoginException("账号被锁定！");


        //ip地址验证
        String allowIps = user.getAllowIps();
        boolean result = false;
        if(StringUtils.isNoneBlank(allowIps)){
            String[] split = allowIps.split(",");
            for (String s : split) {
                if(ip.equals(s)){
                   result = true;
                   break;
                }
            }
        }
        if(!result) throw new LoginException("ip地址不允许访问！");

        /*if(!ip.equals(user.getAllowIps())) {
            throw new LoginException("ip地址不允许访问");
        }*/
        return user;
    }

    @Override
    public TabUser User(String loginAct, String loginPwd, String ip) {
        TabUser user = userMapper.getUser(loginAct,loginPwd);
        //验证账号密码
        if(user==null) return null;


        //失效时间
        try {
            long endTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(user.getExpireTime()).getTime();

            long time = System.currentTimeMillis();
            if(time>endTime) return null;

        } catch (ParseException e) {
            return null;
        }


        //锁定状态
        if("0".equals(user.getLockStatus())) return null;


        //ip地址验证

        String allowIps = user.getAllowIps();
        boolean result = false;
        if(StringUtils.isNoneBlank(allowIps)){
            String[] split = allowIps.split(",");
            for (String s : split) {
                if(ip.equals(s)){
                    result = true;
                    break;
                }
            }
        }
        if(!result) return null;

        return user;
    }

    @Override
    public List<String> getOwner() {
        return userMapper.getOwner();
    }

   /* @Override
    public void updateUser(String oldPwd, String newPwd, HttpSession session) {
        TabUser loginAct = (TabUser)session.getAttribute("LoginAct");
        if(!(loginAct.getLoginPwd().equals(oldPwd))){
            
        }

    }*/


}
