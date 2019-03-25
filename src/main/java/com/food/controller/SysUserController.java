package com.food.controller;

import com.food.entity.TblSysUser;
import com.food.service.SysUserService;
import com.food.util.PageUtils;
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
@RequestMapping("/sysuser")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/tosysuser")
    public String toSysuser(){
        return "/sysuserinfo";
    }


    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<TblSysUser> query(int rows, int page, String userName){
        PageUtils<TblSysUser>   pageUtils=new PageUtils<TblSysUser>();
        pageUtils.setPage(page);
        pageUtils.setPageSize(rows);
        Map<String,String> querp=new HashMap<>();
        querp.put("userName",userName);
        pageUtils.setQueryParam(querp);
        sysUserService.queryUser(pageUtils);
        return pageUtils;
    }
}
