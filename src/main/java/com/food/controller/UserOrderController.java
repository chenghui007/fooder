package com.food.controller;

import com.food.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Controller
@RequestMapping("/userorder")
public class UserOrderController {


    @Autowired
    private UserOrderService userOrderService;

    /**
     * 查询菜品分类和菜品
     *
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public Map<String, String> userIndex() {
        Map<String,String> result=new HashMap<String, String>();
        try {
            userOrderService.queryDisher(result);
        }catch (Exception e){
            result.put("code","0001");
            result.put("desc","系统异常");
        }
        return result;
    }
}
