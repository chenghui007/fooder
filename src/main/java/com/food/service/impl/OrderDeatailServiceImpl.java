package com.food.service.impl;

import com.alibaba.fastjson.JSON;
import com.food.dao.TblOrderDetailMapper;
import com.food.dao.TblOrderInfoMapper;
import com.food.entity.TblOrderDetailExample;
import com.food.entity.TblOrderInfo;
import com.food.entity.TblOrderInfoExample;
import com.food.service.OrderDeatilService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
@Service
public class OrderDeatailServiceImpl implements OrderDeatilService {


    @Autowired
    private TblOrderDetailMapper tblOrderDetailMapper;
    @Autowired
    private TblOrderInfoMapper tblOrderInfoMapper;

    @Override
    public void queryOrderInfo(Map<String, String> result) {
        TblOrderInfoExample example = new TblOrderInfoExample();
        example.setLimitEnd(1);
        example.setLimitStart(0);
        example.setOrderByClause("order_time desc");
        example.createCriteria().andStatusEqualTo("010");
        List<TblOrderInfo> list = tblOrderInfoMapper.selectByExample(example);
        if (list == null || list.size() <= 0){
            result.put("code","0001");
            result.put("desc","没有最新下单的数据");
            return;
        }
        TblOrderInfo tblOrderInfo=list.get(0);
        if("010".equals(tblOrderInfo.getStatus())){
            tblOrderInfo.setStatus("待制作");
        }
        if("020".equals(tblOrderInfo.getStatus())){
            tblOrderInfo.setStatus("已完成");
        }
        result.put("code","0000");
        result.put("desc", JSON.toJSONString(list.get(0)));
    }

    @Override
    public Map<String, Object> queryOrderDeatil(String orderNo) {
        Map<String,Object>  map=new HashedMap();
        TblOrderInfoExample tblOrderInfoExample=new TblOrderInfoExample();
        tblOrderInfoExample.createCriteria().andOrderNoEqualTo(orderNo);
        map.put("waittime",tblOrderInfoMapper.selectByExample(tblOrderInfoExample).get(0).getWaitTime());
        TblOrderDetailExample detailExample=new TblOrderDetailExample();
        detailExample.createCriteria().andOrderNoEqualTo(orderNo);
        map.put("details",tblOrderDetailMapper.selectByExample(detailExample));
        return map;
    }

    @Override
    public void endOrder(Map<String, String> result) {
        String orderNo=result.get("orderNo");
        TblOrderInfoExample example = new TblOrderInfoExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        TblOrderInfo tblOrderInfo=new TblOrderInfo();
        tblOrderInfo.setStatus("020");
        tblOrderInfo.setOrderEndTime(new Date());
        tblOrderInfoMapper.updateByExampleSelective(tblOrderInfo,example);
        result.clear();
        result.put("code","0000");
        result.put("desc","订单已完成");
    }
}
