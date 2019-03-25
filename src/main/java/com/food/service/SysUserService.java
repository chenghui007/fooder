package com.food.service;

import com.food.entity.TblSysUser;
import com.food.util.PageUtils;

/**
 * Created by chenghui on 2019/3/24.
 */
public interface SysUserService {
    void queryUser(PageUtils<TblSysUser> pageUtils);
}
