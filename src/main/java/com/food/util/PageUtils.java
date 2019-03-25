package com.food.util;

import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
public class PageUtils<T> {

    private int  pageSize;  //每页长度

    private List<T> rows;  //返回数据


    private int total ; //总长度

    private int  page;

    private Map<String,String> queryParam;

    public Map<String, String> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, String> queryParam) {
        this.queryParam = queryParam;
    }

    public PageUtils(int pageSize, List<T> rows, int total, int page) {
        this.pageSize = pageSize;
        this.rows = rows;
        this.total = total;
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public  int getStartIndex(){
        return (page-1)*pageSize;
    }

    public PageUtils() {
    }


    public String getInfo(String key){
        if(this.queryParam != null){
            return this.getQueryParam().get(key);
        }
        return null;
    }
}
