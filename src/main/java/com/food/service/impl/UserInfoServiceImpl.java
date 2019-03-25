package com.food.service.impl;

import com.food.dao.TblUserInfoMapper;
import com.food.entity.TblUserInfo;
import com.food.entity.TblUserInfoExample;
import com.food.service.UserInfoService;
import com.food.util.PageUtils;
import com.food.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private TblUserInfoMapper tblUserInfoMapper;


    public Map<String, String> resUser(TblUserInfo tblUserInfo) {
        tblUserInfo.setCreateTime(new Date());
        tblUserInfoMapper.insertSelective(tblUserInfo);
        Map<String, String>   result=new HashMap<String, String>();
        result.put("code","0000");
        result.put("desc","注册成功");
        return result;
    }

    public Map<String, String> userLogin(String username, String password) {
            Map<String, String>  map=new HashMap<String, String>();
            TblUserInfoExample example=new TblUserInfoExample();
            example.createCriteria().andUserNameEqualTo(username);
            List<TblUserInfo> list=tblUserInfoMapper.selectByExample(example);
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

    @Override
    public void queryUser(PageUtils<TblUserInfo> pageUtils) {
        TblUserInfoExample example = new TblUserInfoExample();
        example.setLimitStart(pageUtils.getStartIndex());
        example.setLimitEnd(pageUtils.getPageSize());
        TblUserInfoExample.Criteria criteria=example.createCriteria();
        if (!StringUtils.isEmpty(pageUtils.getInfo("userName"))) {
            criteria.andUserNameLike("%"+pageUtils.getInfo("userName")+"%");
        }
        int count = tblUserInfoMapper.countByExample(example);
        if (count <= 0) {
            return;
        }
        pageUtils.setTotal(count);
        pageUtils.setRows(tblUserInfoMapper.selectByExample(example));
    }
}
