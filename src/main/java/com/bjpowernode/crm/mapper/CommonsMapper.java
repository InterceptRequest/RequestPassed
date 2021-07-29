package com.bjpowernode.crm.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CommonsMapper {
    List<Map> getAll(String tableName);
    Map getId(@Param("tableName") String tableName,@Param("id") Serializable id);
    int insert(@Param("tableName") String tableName,@Param("map") Map map);
    int update(@Param("tableName") String tableName,@Param("map") Map map);
    int delete (@Param("tableName") String tableName,@Param("ids") Serializable... ids);
}
