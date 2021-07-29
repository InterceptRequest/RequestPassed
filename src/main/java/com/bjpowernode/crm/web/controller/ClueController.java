package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Page;
import com.bjpowernode.crm.service.ClueService;
import com.bjpowernode.crm.web.Result;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("clue")
public class ClueController {
    @Resource
    ClueService clueService;

    @GetMapping("getPage.json")
    public Page getPage(@RequestParam Map map, Page page){
        clueService.getParge(map,page);
        return page;
    }

    @GetMapping("getActivities.json")
    public List activities (String clued){
        return clueService.getActivities(clued);
    }
}
