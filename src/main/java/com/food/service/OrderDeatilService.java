package com.food.service;

import com.food.entity.TblOrderDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
public interface OrderDeatilService {
    void queryOrderInfo(Map<String, String> result);

    List<TblOrderDetail> queryOrderDeatil(String orderNo);

    void endOrder(Map<String, String> result);
}
