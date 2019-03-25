package com.food.service.impl;

import com.food.dao.TblDishesInfoMapper;
import com.food.entity.TblDishesInfo;
import com.food.entity.TblDishesInfoExample;
import com.food.service.DisherService;
import com.food.util.Contants;
import com.food.util.PageUtils;
import com.food.util.StringUtils;
import com.food.util.SysDicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class DisherServiceImpl implements DisherService {

    @Autowired
    private TblDishesInfoMapper  tblDishesInfoMapper;

    public void query(PageUtils<TblDishesInfo> pageUtils) {
        TblDishesInfoExample example=new TblDishesInfoExample();
        example.setLimitStart(pageUtils.getStartIndex());
        example.setLimitEnd(pageUtils.getPageSize());
        TblDishesInfoExample.Criteria criteria=  example.createCriteria();
        if(!StringUtils.isEmpty(pageUtils.getInfo("disherName"))){
            criteria.andDishierNameLike("%"+pageUtils.getInfo("disherName")+"%");
        }
        if(!StringUtils.isEmpty(pageUtils.getInfo("disherType"))){
            criteria.andDisherTypeEqualTo(pageUtils.getInfo("disherType"));
        }
        int count=tblDishesInfoMapper.countByExample(example);
        if(count<=0){
            return ;
        }
        pageUtils.setTotal(count);
        List<TblDishesInfo> list=tblDishesInfoMapper.selectByExample(example);
        for (TblDishesInfo info:list) {
            info.setDisherType(SysDicUtils.getValue(Contants.dish_type,info.getDisherType()));
        }
        pageUtils.setRows(list);
    }


    public Map<String, String> add(TblDishesInfo tblDishesInfo) {
        Map<String, String>  map=new HashMap<String, String>();
        tblDishesInfoMapper.insert(tblDishesInfo);
        map.put("code","0000");
        map.put("desc","上架成功");
        return map;
    }
}
