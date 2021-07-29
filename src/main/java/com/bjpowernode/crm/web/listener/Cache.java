package com.bjpowernode.crm.web.listener;

import com.bjpowernode.crm.pojo.Value;
import com.bjpowernode.crm.service.ValueService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener
public class Cache implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        ValueService bean = applicationContext.getBean(ValueService.class);

        List<Value> values = bean.getAll();



       Map<String,List> map = new HashMap<>();
        for (Value value : values) {
            String key=value.getTypeCode();
            List list = map.get(key);
            if(list == null){
                list = new ArrayList();
                map.put(key,list);
            }
            list.add(value);
        }













       /* Map<String, List> map = new HashMap<>();
        for (Value value : values) {
            String key = value.getTypeCode();
            List list = map.get(key);
            if (list == null) {
                list = new ArrayList();
                map.put(key, list);
            }
            list.add(value);
        }*/
        // 将字典值保存到application作用域，作为缓存
        sce.getServletContext().setAttribute("dicMapList", map);


    }
}
