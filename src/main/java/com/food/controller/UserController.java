package com.food.controller;

import com.food.entity.TblUserInfo;
import com.food.service.UserInfoService;
import com.food.util.PageUtils;
import com.food.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/touserinfo")
    public String toUserInfo(){
        return "/userinfo";
    }

    @RequestMapping("/userRes")
    @ResponseBody
    public Map<String, String> resUser(TblUserInfo tblUserInfo) {
        Map<String, String> result = new HashMap<String, String>();
        if (StringUtils.isEmpty(tblUserInfo.getUserName())) {
            result.put("code", "0001");
            result.put("desc", "请输入用户名");
        }
        if (StringUtils.isEmpty(tblUserInfo.getPassword())) {
            result.put("code", "0001");
            result.put("desc", "请输入密码");
        }
        result = userInfoService.resUser(tblUserInfo);
        return result;
    }


    @RequestMapping("/userlogin")
    @ResponseBody
    public Map<String, String> userlogin(String username, String password) {
        Map<String, String>  result=new HashMap<String, String>();
        if (StringUtils.isEmpty(username)) {
            result.put("code","0001");
            result.put("desc","请输入用户名");
        }
        if (StringUtils.isEmpty(password)) {
            result.put("code","0001");
            result.put("desc","请输入密码");
        }
        result=userInfoService.userLogin(username,password);
        return result;
    }

    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<TblUserInfo> query(int rows,int page,String userName){
        PageUtils<TblUserInfo>   pageUtils=new PageUtils<TblUserInfo>();
        pageUtils.setPage(page);
        pageUtils.setPageSize(rows);
        Map<String,String> querp=new HashMap<>();
        querp.put("userName",userName);
        pageUtils.setQueryParam(querp);
        userInfoService.queryUser(pageUtils);
        return pageUtils;
    }
}
