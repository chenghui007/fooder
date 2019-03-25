package com.food.service.impl;

import com.food.dao.TblSysUserMapper;
import com.food.entity.TblSysUser;
import com.food.entity.TblSysUserExample;
import com.food.service.SysUserService;
import com.food.util.PageUtils;
import com.food.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenghui on 2019/3/24.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private TblSysUserMapper tblSysUserMapper;

    @Override
    public void queryUser(PageUtils<TblSysUser> pageUtils) {
        TblSysUserExample example = new TblSysUserExample();
        example.setLimitStart(pageUtils.getStartIndex());
        example.setLimitEnd(pageUtils.getPageSize());
        TblSysUserExample.Criteria criteria=example.createCriteria();
        if (!StringUtils.isEmpty(pageUtils.getInfo("userName"))) {
            criteria.andLoginUserEqualTo("%"+pageUtils.getInfo("userName")+"%");
        }
        int count = tblSysUserMapper.countByExample(example);
        if (count <= 0) {
            return;
        }
        pageUtils.setTotal(count);
        pageUtils.setRows(tblSysUserMapper.selectByExample(example));

    }
}
