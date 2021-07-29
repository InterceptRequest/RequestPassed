package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Page;

import java.util.List;
import java.util.Map;

public interface ClueService {

    void getParge(Map map, Page page);

    List getActivities(String clued);
}
