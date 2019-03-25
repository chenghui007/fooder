package com.food.service.impl;

import com.food.dao.TblSysMenuInfoMapper;
import com.food.dao.TblSysUserMapper;
import com.food.entity.TblSysMenuInfo;
import com.food.entity.TblSysMenuInfoExample;
import com.food.entity.TblSysUser;
import com.food.entity.TblSysUserExample;
import com.food.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private TblSysUserMapper tblSysUserMapper;

    @Autowired
    private TblSysMenuInfoMapper tblSysMenuInfoMapper;


    public Map<String, String> loginSys(String username, String password) {
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
        return map;
    }

    public List<TblSysMenuInfo> queryMenu() {
        return tblSysMenuInfoMapper.selectByExample(null);
    }
}
