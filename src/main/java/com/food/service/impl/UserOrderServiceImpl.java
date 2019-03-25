package com.food.service.impl;

import com.alibaba.fastjson.JSON;
import com.food.dao.TblDishesInfoMapper;
import com.food.dao.TblSysDicMapper;
import com.food.entity.TblDishesInfo;
import com.food.entity.TblDishesInfoExample;
import com.food.entity.TblSysDic;
import com.food.entity.TblSysDicExample;
import com.food.service.UserOrderService;
import com.food.util.Contants;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {


    private static final Logger logger = Logger.getLogger(UserOrderServiceImpl.class);

    @Autowired
    private TblSysDicMapper tblSysDicMapper;
    @Autowired
    private TblDishesInfoMapper tblDishesInfoMapper;


    public void queryDisher(Map<String, String> result) {
        TblSysDicExample tblSysDicExample = new TblSysDicExample();
        tblSysDicExample.createCriteria().andTypeEqualTo(Contants.dish_type);
        List<TblSysDic> diserType = tblSysDicMapper.selectByExample(tblSysDicExample);
        String disherTypeStr = JSON.toJSONString(diserType);
        logger.info("查询出的菜品类型为==>" + disherTypeStr);
        List<Map<String,Object>>  list=new ArrayList<Map<String, Object>>();
        for (TblSysDic dic : diserType) {
            Map<String, Object> disher = new HashMap<String,Object>();
            disher.put(dic.getParam(),queryDisher(dic.getParam()));
            disher.put(dic.getParam(),dic.getParamValue());
            list.add(disher);
        }
        String disherStr = JSON.toJSONString(list);
        result.put("desc",disherStr);
        result.put("code","0000");
        logger.info("查询出的全部菜品为==>" + disherTypeStr);
    }


    private List<TblDishesInfo> queryDisher(String disher_type) {
        TblDishesInfoExample example = new TblDishesInfoExample();
        example.createCriteria().andDisherTypeEqualTo(disher_type);
        return tblDishesInfoMapper.selectByExample(example);
    }
}
