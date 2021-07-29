package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Dept;
import com.bjpowernode.crm.service.DeptService;
import com.bjpowernode.crm.utils.UUIDUtil;
import com.bjpowernode.crm.web.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping("getAll.json")
    public List<Dept> getAll(){
        return deptService.getALl();
    }
    @RequestMapping("getId.json")
    public Dept getId(String id){
        System.out.println(id);
        return deptService.getId(id);
    }
    @RequestMapping("insert.do")
    public Map insert(Dept dept){
        dept.setId(UUIDUtil.getUUID());
        deptService.getOn(dept.getNo());
        deptService.insert(dept);
        return Result.SUCCESS;
    }
    @RequestMapping("delete.do")
    public Map delete(String[] ids){
        deptService.delete(ids);

        return Result.SUCCESS;
    }
    @RequestMapping("update.do")
    public Map update(Dept dept){
        System.out.println(dept+"======================-------------0-8907867");
        deptService.update(dept);
        return Result.SUCCESS;
    }
}
