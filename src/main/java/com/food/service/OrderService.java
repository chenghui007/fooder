package com.food.service;

import com.food.entity.TblOrderDetail;
import com.food.entity.TblOrderInfo;
import com.food.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
public interface OrderService {
    void queryOrder(PageUtils<TblOrderInfo> pageUtils);

    List<TblOrderInfo> queryEarn();

    Map<String,String> reqOrder(TblOrderInfo tblOrderInfo, List<TblOrderDetail> details);
}
