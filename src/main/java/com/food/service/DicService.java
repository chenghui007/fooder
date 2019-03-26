package com.food.service;

import com.food.entity.TblDishesInfo;
import com.food.entity.TblSysDic;

import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
public interface DicService {
    List<Map<String, Object>> queryDic();

    List<TblSysDic> queryDish(String dishtype);
}
