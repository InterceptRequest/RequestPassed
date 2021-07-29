package com.bjpowernode.crm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClueMapper {

    Integer getCount(@Param("map")Map map);

    List getData(@Param("map") Map map,@Param("indexLimit") Integer indexLimit, @Param("rowsPerPage") Integer rowsPerPage);


}
