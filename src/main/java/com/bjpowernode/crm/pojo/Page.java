package com.bjpowernode.crm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    private Integer currentPage =1;
    private Integer rowsPerPage =3;
    private Integer maxRowsPerPage =5;
    private Integer visiblePageLinks = 5;
    private Integer totalPages;
    private Integer totalRows;
    private List data;
}
