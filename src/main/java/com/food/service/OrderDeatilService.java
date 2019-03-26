package com.food.service;

import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
public interface OrderDeatilService {
    void queryOrderInfo(Map<String, String> result);

    Map<String, Object> queryOrderDeatil(String orderNo);

    void endOrder(Map<String, String> result);
}
