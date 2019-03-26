package com.food.controller;

import com.food.entity.TblSysMenuInfo;
import com.food.service.LoginService;
import com.food.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenghui on 2019/3/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> loginSys(String username, String password, HttpServletRequest request) {
        Map<String, String>  result=new HashMap<String, String>();
        if (StringUtils.isEmpty(username)) {
            result.put("code","0001");
            result.put("desc","请输入用户名");
            return result;
        }
        if (StringUtils.isEmpty(password)) {
            result.put("code","0001");
            result.put("desc","请输入密码");
            return result;
        }
        result=loginService.loginSys(username,password);
        return result;
    }
    @RequestMapping("/main")
    public  String toFrame() {
        return "/frame";
    }
    @RequestMapping("/tree")
    @ResponseBody
    public List<TblSysMenuInfo> queryMenu(String userid){
        return loginService.queryMenu(userid);
    }
}
