package com.food.service.impl;

import com.food.dao.TblDishesInfoMapper;
import com.food.dao.TblSysDicMapper;
import com.food.entity.*;
import com.food.service.DicService;
import com.food.util.Contants;
import com.food.util.SysDicUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class DicServiceImpl implements DicService {


    @Autowired
    private TblSysDicMapper tblSysDicMapper;

    @Autowired
    private TblDishesInfoMapper tblDishesInfoMapper;


    public List<Map<String, Object>> queryDic() {
        List<Map<String,Object>>  list=new ArrayList<>();
        List<TblSysDic> infos =queryDicByType(Contants.dish_type);
        for (TblSysDic dic:infos) {
            Map<String,Object>  item=new HashedMap();
            item.put("disher",dic);
            item.put("dishlist",queryDish(dic.getParam()));
            list.add(item);
        }
        return list;
    }

    @Override
    public List<TblSysDic> queryDish(String dishtype) {
        TblSysDicExample example=new TblSysDicExample();
        example.createCriteria().andTypeEqualTo(Contants.dish_type);
        return tblSysDicMapper.selectByExample(example);
    }


    private  List<TblSysDic>  queryDicByType(String type){
        TblSysDicExample example=new TblSysDicExample();
        example.createCriteria().andTypeEqualTo(type);
        return tblSysDicMapper.selectByExample(example);
    }

}
