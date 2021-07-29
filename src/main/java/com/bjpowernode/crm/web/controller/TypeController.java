package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Type;
import com.bjpowernode.crm.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("type")
public class TypeController {
    @Resource
    TypeService typeService;

    @ResponseBody
    @RequestMapping("codeVerification.json")
    public boolean codeVerification(String code){
        return typeService.codeVerification(code);
    }


    @RequestMapping("save.do")
    public String saveType(Type type){
        typeService.addType(type);
        return "redirect:/type/getAll.html";
    }
    @RequestMapping("delete.do")
    public String delete(String[] ids){
        typeService.delete(ids);
        return "redirect:/type/getAll.html";
    }
    @RequestMapping("update.html")
    public ModelAndView update(String code){
        ModelAndView mv = new ModelAndView();
        mv.addObject("type",typeService.getId(code));
        mv.setViewName("/settings/dictionary/type/edit");
        return mv;
    }

    @RequestMapping("getAll.html")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        List<Type> all = typeService.getAll();
        mv.addObject("typeALl",all);
        mv.setViewName("/settings/dictionary/type/index");
        return mv;
    }
    @RequestMapping("/update.do")
    public String update(Type type){
        typeService.update(type);
        return "redirect:/type/getAll.html";
    }
    @ResponseBody
    @RequestMapping("delete.json")
    public List<String> deleteJson(String...ids){
        return typeService.getUsed(ids);
    }
}
