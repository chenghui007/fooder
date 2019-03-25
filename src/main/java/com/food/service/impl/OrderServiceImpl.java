package com.food.service.impl;

import com.food.dao.TblDishesInfoMapper;
import com.food.dao.TblOrderDetailMapper;
import com.food.dao.TblOrderInfoMapper;
import com.food.entity.TblDishesInfo;
import com.food.entity.TblOrderDetail;
import com.food.entity.TblOrderInfo;
import com.food.entity.TblOrderInfoExample;
import com.food.service.OrderService;
import com.food.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private TblOrderInfoMapper tblOrderInfoMapper;

    @Autowired
    private TblOrderDetailMapper tblOrderDetailMapper;

    @Autowired
    private TblDishesInfoMapper tblDisherMapper;

    public void queryOrder(PageUtils<TblOrderInfo> pageUtils) {
        TblOrderInfoExample example = new TblOrderInfoExample();
        example.setLimitStart(pageUtils.getStartIndex());
        example.setLimitEnd(pageUtils.getPageSize());
        if (!StringUtils.isEmpty(pageUtils.getInfo("orderNo"))) {
            example.createCriteria().andOrderNoEqualTo(pageUtils.getInfo("orderNo"));
        }
        int count = tblOrderInfoMapper.countByExample(example);
        if (count <= 0) {
            return;
        }
        pageUtils.setTotal(count);
        pageUtils.setRows(tblOrderInfoMapper.selectByExample(example));

    }

    /**
     * 查询当天的收益总和
     */
    public List<TblOrderInfo> queryEarn() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");
        String today = simpleDateFormat.format(now);
        TblOrderInfoExample example = new TblOrderInfoExample();
        TblOrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrderDateEqualTo(today);
        criteria.andStatusEqualTo("020");
        return tblOrderInfoMapper.selectByExample(example);

    }

    public Map<String, String> reqOrder(TblOrderInfo tblOrderInfo, List<TblOrderDetail> details) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            SnowflakeIdWorker snow = new SnowflakeIdWorker(0, 0);
            String orderNo = String.valueOf(snow.nextId());
            tblOrderInfo.setOrderNo(orderNo);
            int minus = 0;
            int total_money = 0;
            for (TblOrderDetail detail : details) {
                detail.setOrderNo(orderNo);
                detail.setCreateTime(new Date());
                TblDishesInfo info = getDisherInfo(detail.getDisherId());
                detail.setDisherName(info.getDishierName());
                detail.setDisherType(info.getDisherType());
                Integer money = Integer.valueOf(detail.getNumber()) * info.getPrice();
                total_money += money; //总金额
                detail.setTotalMoney(String.valueOf(money));
                Integer min = info.getMakeTime() * Integer.valueOf(detail.getNumber());
                minus += min; //总计等待时间
                detail.setDisherTypeName(SysDicUtils.getValue(Contants.dish_type, info.getDisherType()));
                tblOrderDetailMapper.insertSelective(detail);
            }
            tblOrderInfo.setOrderMoney(total_money);
            tblOrderInfo.setWaitTime(minus);
            tblOrderInfo.setStatus("010"); //等待出餐
            tblOrderInfo.setOrderTitle("下单了");
            tblOrderInfo.setOrderTime(new Date());
            Date now = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");
            String today = simpleDateFormat.format(now);
            tblOrderInfo.setOrderDate(today);
            tblOrderInfoMapper.insert(tblOrderInfo);
            result.put("code", "0000");
            result.put("desc", orderNo);
        } catch (Exception e) {
            result.put("code", "0001");
            result.put("desc", "系统异常,请稍后重试");
        }
        return result;
    }

    private TblDishesInfo getDisherInfo(int id) {
        return tblDisherMapper.selectByPrimaryKey(id);
    }

}
