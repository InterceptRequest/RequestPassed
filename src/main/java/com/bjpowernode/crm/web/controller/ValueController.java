package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Value;
import com.bjpowernode.crm.service.TypeService;
import com.bjpowernode.crm.service.ValueService;

import com.bjpowernode.crm.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("value")
public class ValueController {
    @Resource
    ValueService valueService;
    @Resource
    TypeService typeService;
    @RequestMapping("index.html")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/settings/dictionary/value/index");
        mv.addObject("value",valueService.getAll());
        return mv;
    }

    @RequestMapping("delete.do")
    public String delete(String [] ids){
        valueService.delete(ids);
        return "redirect:/value/index.html";
    }
    @RequestMapping("save.html")
    public ModelAndView save(ModelAndView mv){
        mv.addObject("type",typeService.getAll());
        mv.setViewName("/settings/dictionary/value/save");
        return mv;
    }

    @RequestMapping("insert.do")
    public String insert (Value value){
        value.setId(UUIDUtil.getUUID());
        valueService.insert(value);
        return "redirect:/value/index.html";
    }
    @RequestMapping("update.html")
    public ModelAndView updateHtml(String id,ModelAndView mv){
        mv.addObject("value",valueService.getId(id));
        mv.setViewName("/settings/dictionary/value/edit");
        return mv;
    }

    @RequestMapping("update.do")
    public String update(Value value){
        valueService.update(value);
        return "redirect:/value/index.html";
    }
}
