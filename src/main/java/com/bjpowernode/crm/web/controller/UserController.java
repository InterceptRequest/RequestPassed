package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.TabUser;
import com.bjpowernode.crm.service.UserService;
import com.bjpowernode.crm.utils.MD5Util;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("/verification.do")
    public Map userVerification(String loginAct, String loginPwd, HttpServletRequest request,
                                boolean checkbox, HttpServletResponse response){
        System.out.println("-=登录方法执行=-");

        if(checkbox){
            int time = 1000 * 60 * 60 * 24 * 10;
            Cookie co1 = new Cookie("GFES31",loginAct);
            co1.setMaxAge(time);
            co1.setPath("/");

            Cookie co2 = new Cookie("J3421C", MD5Util.getMD5(loginPwd));
            co2.setMaxAge(time);
            co2.setPath("/");

            response.addCookie(co1);
            response.addCookie(co2);
            System.out.println("/--Cookie注册完成--\\");
        }


        String ip = request.getRemoteAddr();
        TabUser user = userService.getUser(loginAct, loginPwd,ip);
        request.getSession().setAttribute("LoginAct",user);
        return new HashedMap(){{
            put("success",true);
        }};
    }


    @RequestMapping("/index.do")
    public String index(HttpServletResponse response, HttpSession session){
        Cookie cookie = new Cookie("GFES31",null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        session.removeAttribute("LoginAct");
        return "redirect:/";
    }

   /* @RequestMapping("update.do")
    public String updateUser (String oldPwd,String newPwd,HttpSession session){
        userService.updateUser(oldPwd,newPwd,session);
        return null;
    }*/

    @ResponseBody
    @RequestMapping("getOwner.json")
    public List<String> getOwner (){
        return userService.getOwner();
    }
}
