package com.bjpowernode.crm.service.impl;

import com.bjpowernode.crm.mapper.TranMapper;
import com.bjpowernode.crm.pojo.Page;
import com.bjpowernode.crm.pojo.Tran;
import com.bjpowernode.crm.service.TranService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class TranServiceImpl implements TranService {
    @Resource
    private TranMapper tranMapper;

    @Override
    public void getTran(Map map, Page page) {
        Integer count  = tranMapper.count(map);

        Integer rowsPerpage = page.getRowsPerPage();

        Integer totalPage = (count-1 / rowsPerpage+1);

        Integer index = (page.getCurrentPage()-1) * rowsPerpage;

        List tran = tranMapper.getData(map,index,rowsPerpage);

        page.setTotalPages(totalPage);

        page.setTotalRows(count);

        page.setData(tran);
    }

    @Override
    public List getGroup() {
        return tranMapper.getGroup();
    }
}
