package com.bjpowernode.crm.service;

import com.bjpowernode.crm.pojo.Page;

import java.util.List;
import java.util.Map;

public interface TranService {
    void getTran(Map map, Page page);

    List getGroup();
}
