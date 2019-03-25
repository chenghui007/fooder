package com.food.controller;

import com.food.entity.TblOrderDetail;
import com.food.service.OrderDeatilService;
import com.food.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
@Controller
    @RequestMapping("/orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDeatilService orderDeatilService;


    @RequestMapping("/toorderdetail")
    public String  toOrderDeatil(){
        return "/orderdetail";
    }

    /**
     * 查询最近的订单信息
     * @return
     */
    @RequestMapping("/queryOrder")
    @ResponseBody
    public Map<String, String> queryNewOrder(){
        Map<String,String> result=new HashMap<>();
        orderDeatilService.queryOrderInfo(result);
        return result;
    }

    /**
     * 查询对应的订单详情信息
     * @return
     */
    @RequestMapping("/queryOrderdetail")
    @ResponseBody
    public List<TblOrderDetail> queryOrderDeatl(String orderNo){
        if(StringUtils.isEmpty(orderNo)){
            return null;
        }
        return orderDeatilService.queryOrderDeatil(orderNo);
    }

    /**
     * 完成订单
     * @param orderNo
     * @return
     */
    @RequestMapping("/endOrder")
    @ResponseBody
    public Map<String,String>  endOrder(String orderNo){
        Map<String,String> result=new HashMap<>();
        result.put("orderNo",orderNo);
        orderDeatilService.endOrder(result);
        return result;
    }
}
