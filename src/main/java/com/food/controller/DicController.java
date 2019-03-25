package com.food.controller;

import com.food.entity.TblSysDic;
import com.food.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenghui on 2019/3/23.
 */
@Controller
@RequestMapping("/dic")
public class DicController {


    @Autowired
    private DicService dicService;


    @RequestMapping("/dishertype")
    @ResponseBody
    public List<TblSysDic> queryDic(){
        return dicService.queryDic();
    }
}

