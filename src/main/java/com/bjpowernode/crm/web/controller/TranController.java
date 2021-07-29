package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Page;
import com.bjpowernode.crm.service.TranService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tran")
public class TranController {
    @Resource
    TranService tranService;
    @RequestMapping("getTran.json")
    public Page getTran (@RequestParam Map map, Page page){
        tranService.getTran(map,page);
        return page;
    }

    @RequestMapping("getGroup.json")
    public List getGroup(){
        return tranService.getGroup();
    }
}
