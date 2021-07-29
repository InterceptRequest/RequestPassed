package com.bjpowernode.crm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TranMapper {
    Integer count(@Param("map") Map map) ;

    List getData(@Param("map")Map map, @Param("index")Integer index, @Param("rowsPerpage")Integer rowsPerpage);

    List getGroup();
}
