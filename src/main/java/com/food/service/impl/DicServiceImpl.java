package com.food.service.impl;

import com.food.dao.TblSysDicMapper;
import com.food.entity.TblSysDic;
import com.food.entity.TblSysDicExample;
import com.food.service.DicService;
import com.food.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class DicServiceImpl implements DicService {


    @Autowired
    private TblSysDicMapper tblSysDicMapper;


    public List<TblSysDic> queryDic() {
        return queryDicByType(Contants.dish_type);
    }



    private  List<TblSysDic>  queryDicByType(String type){
        TblSysDicExample example=new TblSysDicExample();
        example.createCriteria().andTypeEqualTo(type);
        return tblSysDicMapper.selectByExample(example);
    }

}
