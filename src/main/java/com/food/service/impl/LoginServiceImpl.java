package com.food.service.impl;

import com.food.dao.TblSysMenuInfoMapper;
import com.food.dao.TblSysUserMapper;
import com.food.entity.*;
import com.food.service.LoginService;
import com.food.util.Contants;
import com.food.util.SysDicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private TblSysUserMapper tblSysUserMapper;

    @Autowired
    private TblSysMenuInfoMapper tblSysMenuInfoMapper;


    public Map<String, String> loginSys(String username, String password){
        Map<String, String>  map=new HashMap<String, String>();
        TblSysUserExample example=new TblSysUserExample();
        example.createCriteria().andLoginUserEqualTo(username);
        List<TblSysUser> list=tblSysUserMapper.selectByExample(example);
        if(list ==null || list.size() <=0){
            map.put("code","0001");
            map.put("desc","用户不存在");
            return map;
        }
        if(!list.get(0).getPassword().equals(password)){
            map.put("code","0001");
            map.put("desc","密码不正确");
            return map;
        }
        map.put("code","0000");
        map.put("desc","登录成功");
        map.put("userid", String.valueOf(list.get(0).getId()));
        return map;
    }

    public List<TblSysMenuInfo> queryMenu(String userid) {
        TblSysUser infos=tblSysUserMapper.selectByPrimaryKey(Integer.valueOf(userid));
        String qx=SysDicUtils.getValue(Contants.role_menu,infos.getRole());
        TblSysMenuInfoExample example=new TblSysMenuInfoExample();
        String[] arr=qx.split(",");
        List<Integer> ql=new ArrayList<>();
        for (String i:arr) {
            ql.add(Integer.valueOf(i));
        }
        example.createCriteria().andIdIn(ql);
        return tblSysMenuInfoMapper.selectByExample(example);
    }
}
