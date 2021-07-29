package com.bjpowernode.crm.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userAccount = request.getSession().getAttribute("LoginAct");
        if(userAccount==null){
            System.out.println("拦截器false");
            response.sendRedirect("/");
            return false;
        }
        System.out.println("拦截器true");
        return true;
    }
}
