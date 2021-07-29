package com.bjpowernode.crm.web.advice;

import com.bjpowernode.crm.exception.LoginException;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class MyException {
    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Map LoginException(Exception e){
        System.out.println("======LoginException方法执行======");
        return new HashedMap(){{
           put("success",false);
           put("msg",e.getMessage());
        }};
    }
}
