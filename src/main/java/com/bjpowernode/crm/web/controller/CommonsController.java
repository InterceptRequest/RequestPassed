package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.TabUser;
import com.bjpowernode.crm.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonsController {
    @Resource
    UserService userService;
   @RequestMapping("/**/*.html")
    public String uriRequestALl (HttpServletRequest request){
        String uri = request.getRequestURI();
        System.out.println("======执行路径:"+uri);
        return uri.substring(1,uri.lastIndexOf("."));
    }

    @RequestMapping("/")
    public String cookies(@CookieValue(value = "GFES31", required = false) String loginAct,
                          @CookieValue(value = "J3421C",required = false) String loginPwd,
                          HttpServletRequest request){
        System.out.println("--------Cookie验证--------");
        if(StringUtils.isNoneBlank(loginAct,loginPwd)) {

            String ip = request.getRemoteAddr();
            TabUser user = userService.User(loginAct, loginPwd, ip);
            if(user!=null) {
                request.getSession().setAttribute("LoginAct", user);
                return "redirect:/workbench/index.html";
            }
        }
        return "index";
    }

}
