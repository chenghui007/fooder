package com.food.service;

import com.food.entity.TblSysMenuInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
public interface LoginService {
    Map<String,String> loginSys(String username, String password);

    List<TblSysMenuInfo> queryMenu(String userid);
}
