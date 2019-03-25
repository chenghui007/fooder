package com.food.controller;

import com.food.entity.TblOrderDetail;
import com.food.entity.TblOrderInfo;
import com.food.service.OrderService;
import com.food.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @RequestMapping("/toorder")
    public String toorder(){
        return "/order";
    }

    @RequestMapping("/toeran")
    public String toorderE(){
        return "/earns";
    }

    /**
     * 查询全部订单
     * @param rows
     * @param page
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<TblOrderInfo>  querOrder(int rows,int page,String orderNo){
        PageUtils<TblOrderInfo>   pageUtils=new PageUtils<TblOrderInfo>();
        pageUtils.setPage(page);
        pageUtils.setPageSize(rows);
        Map<String,String> querp=new HashMap<>();
        querp.put("orderNo",orderNo);
        pageUtils.setQueryParam(querp);
        orderService.queryOrder(pageUtils);
        return pageUtils;
    }

    /**
     * 查询收益
     */
    @RequestMapping("/queryEarn")
    @ResponseBody
    public List<TblOrderInfo>  queryEarn(){
          return  orderService.queryEarn();
    }


    @RequestMapping("/reqOrder")
    @ResponseBody
    public Map<String, String> reqOrder(TblOrderInfo tblOrderInfo, List<TblOrderDetail> details){
        Map<String, String>  result=new HashMap<String, String>();
        if (tblOrderInfo.getTableNumber()!=null) {
            result.put("code","0001");
            result.put("desc","请选择下单桌号");
        }
        result=orderService.reqOrder(tblOrderInfo,details);
        return result;
    }


}
