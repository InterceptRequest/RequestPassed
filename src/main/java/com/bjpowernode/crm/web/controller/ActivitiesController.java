package com.bjpowernode.crm.web.controller;

import com.bjpowernode.crm.pojo.Activities;
import com.bjpowernode.crm.service.ActiviesService;
import com.bjpowernode.crm.utils.ControllerUtils;
import com.bjpowernode.crm.web.Result;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("activities")
public class ActivitiesController {
    @Resource
    ActiviesService activiesService;

    @GetMapping("get.json")
    public List<Activities> get(@RequestParam Map map){
        return activiesService.get(map);
    }

    @GetMapping("getId.json")
    public Map getId(String id){
        return activiesService.getId(id);
    }

    @GetMapping("getAll.json")
    public List<Map> getAll(){
        return activiesService.getAll();
    }

    @PostMapping("insert.do")
    public Map insert(@RequestParam Map map, HttpSession session){
        ControllerUtils.initSaveMap(map,session);
        activiesService.insert(map);
        return Result.SUCCESS;
    }

    @DeleteMapping("delete.do")
    public Map delete(String... ids){
        activiesService.delete(ids);
        return Result.SUCCESS;
    }

    @PutMapping("update.do")
    public Map update(@RequestParam Map map,HttpSession session){
        ControllerUtils.initUpdate(map,session);
        activiesService.update(map);
        return Result.SUCCESS;
    }

    @GetMapping("export.do")
    public void export(HttpServletResponse response,@RequestParam Map map) throws IOException {
        HSSFWorkbook excel = new HSSFWorkbook();
        HSSFSheet sheet = excel.createSheet();

        int i = 0;
        HSSFRow row = sheet.createRow(i++);

        int j = 0;
        row.createCell(j++).setCellValue("名称");
        row.createCell(j++).setCellValue("所有者");
        row.createCell(j++).setCellValue("开始日期");
        row.createCell(j++).setCellValue("结束日期");

        List<Activities> activities = activiesService.get(map);
        for (Activities activity : activities) {
            row = sheet.createRow(i++);
            j = 0;
            row.createCell(j++).setCellValue(activity.getName());
            row.createCell(j++).setCellValue(activity.getOwner());
            row.createCell(j++).setCellValue(activity.getStartDate());
            row.createCell(j++).setCellValue(activity.getEndDate());
        }
        response.addHeader("Content-Disposition", "attachment;filename=activity.xls");
        excel.write(response.getOutputStream());
    }

     @PostMapping("importExcel.do")
     public Map importExcel(MultipartFile file,HttpSession session) throws IOException {

         // 解析Excel
         HSSFWorkbook excel = new HSSFWorkbook(file.getInputStream());
         HSSFSheet sheet = excel.getSheetAt(0);
         int i = 1; // 数据从第2行开始
         HSSFRow row;

         List list = new ArrayList();

         while((row = sheet.getRow(i++)) != null) {
             int j = 0;
             String name = row.getCell(j++).getStringCellValue();
             String owner = row.getCell(j++).getStringCellValue();
             String startDate = row.getCell(j++).getStringCellValue();
             String endDate = row.getCell(j++).getStringCellValue();

             Activities activity = new Activities();
             ControllerUtils.initSave(activity, session);
             activity.setName(name);
             activity.setOwner(owner);
             activity.setStartDate(startDate);
             activity.setEndDate(endDate);

             list.add(activity);

         }

         activiesService.insertList(list);

         return Result.SUCCESS;
     }


}
