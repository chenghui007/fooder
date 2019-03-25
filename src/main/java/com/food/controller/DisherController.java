package com.food.controller;

import com.food.entity.TblDishesInfo;
import com.food.service.DisherService;
import com.food.util.PageUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chenghui on 2019/3/23.
 */
@Controller
@RequestMapping("/disher")
public class DisherController {


    private static final Log logger = LogFactory.getLog(DisherController.class);

    @Autowired
    private DisherService disherService;

    @RequestMapping("/todisher")
    public String toorder(HttpServletRequest request) {
        String url=request.getContextPath();
        request.setAttribute("imageurl",url);
        return "/disher";
    }

    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<TblDishesInfo> query(int rows, int page, String disherName, String disherType) {
        PageUtils<TblDishesInfo> pageUtils = new PageUtils<TblDishesInfo>();
        pageUtils.setPage(page);
        pageUtils.setPageSize(rows);
        Map<String, String> param = new HashMap<String, String>();
        param.put("disherName", disherName);
        param.put("disherType", disherType);
        pageUtils.setQueryParam(param);
        disherService.query(pageUtils);
        return pageUtils;
    }


    @RequestMapping("/add")
    @ResponseBody
    public Map<String, String> add(TblDishesInfo tblDishesInfo, MultipartFile file, HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        String fileName="";
        String savePath = request.getServletContext().getRealPath("");
        //上传时生成的临时文件保存目录
        if(!new File(savePath).exists()){
            new File(savePath).mkdir();
        }
        if (file != null) {
            String oldFileName = file.getOriginalFilename();
            logger.info("当前上传的文件名为:" + oldFileName);
            logger.info("当前上传的路径为:" + savePath);
            String type = oldFileName.indexOf(".") != -1 ? oldFileName.substring(oldFileName.lastIndexOf(".") + 1, oldFileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    fileName = UUID.randomUUID().toString() +"."+type;
                   String  path=savePath+"/"+fileName;
                    try {
                        file.transferTo(new File(path));
                        logger.info("上传图片完成");
                    } catch (IOException e) {
                        logger.info("上传图片异常");
                        logger.error(e.getMessage(),e);
                    }
                }
            }
        }
        tblDishesInfo.setDisherImage(fileName);
        result = disherService.add(tblDishesInfo);
        return result;
    }
}
