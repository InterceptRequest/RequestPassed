package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.mapper.ActivitiesMapper;
import com.bjpowernode.crm.mapper.ClueMapper;
import com.bjpowernode.crm.pojo.Activities;
import com.bjpowernode.crm.pojo.Page;
import com.bjpowernode.crm.service.ClueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ClueServiceImpl implements ClueService {
    @Resource
    ClueMapper clueMapper;

    @Resource
    ActivitiesMapper activitiesMapper ;
    @Override
    public void getParge(Map map, Page page) {

        Integer count = clueMapper.getCount(map); //  查询后的总数据条数
        Integer rowsPerPage = page.getRowsPerPage(); // 每页 显示的 数据数

        Integer totalPage = (count-1 / rowsPerPage+1); //（查询后的总数据数 -1） /（每页显示数据数 +1）  =  总页数

        Integer IndexLimit = (page.getCurrentPage()-1) * rowsPerPage;

        List data =  clueMapper.getData(map,IndexLimit,rowsPerPage);

        page.setData(data);
        page.setTotalRows(count);
        page.setTotalPages(totalPage);
    }

    @Override
    public List getActivities(String clued) {
        return activitiesMapper.getActivities(clued);
    }
}
