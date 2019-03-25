package com.food.service;

import com.food.entity.TblUserInfo;
import com.food.util.PageUtils;

import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
public interface UserInfoService {
    Map<String,String> resUser(TblUserInfo tblUserInfo);

    Map<String,String> userLogin(String username, String password);

    void queryUser(PageUtils<TblUserInfo> pageUtils);
}
