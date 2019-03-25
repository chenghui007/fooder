package com.food.service;

import com.food.entity.TblDishesInfo;
import com.food.util.PageUtils;

import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
public interface DisherService {
    void query(PageUtils<TblDishesInfo> pageUtils);

    Map<String,String> add(TblDishesInfo tblDishesInfo);
}
