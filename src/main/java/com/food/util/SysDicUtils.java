package com.food.util;

import com.food.cache.ApplicationCache;
import com.food.dao.TblSysDicMapper;
import com.food.entity.TblSysDic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by chenghui on 2019/3/23.
 */

@Service
public class SysDicUtils  implements ApplicationContextAware {


    protected static Log logger = LogFactory.getLog(SysDicUtils.class);

    private ApplicationContext applicationContext;

    @Autowired
    private TblSysDicMapper tblSysDicMapper;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }


    @PostConstruct
    public synchronized void init() {
        try {
            logger.info("SysDicUtils.init--初始化字典表开始");
            fillApplicationCache();
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        fillApplicationCache();
                        try {
                            Thread.sleep(30000 * 240);// 每7200秒刷新一次缓存
                        } catch (InterruptedException e) {
                            logger.error("初始化字典表异常", e);
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            logger.debug("SysDicUtils.init初始化字典表异常", e);
            fillApplicationCache();
        }

    }

    private  void fillApplicationCache() {
        List<TblSysDic> list= tblSysDicMapper.selectByExample(null);
        Map<String,HashMap<String,String>> types=new HashMap<String, HashMap<String,String>>();
        for (TblSysDic dic:list) {
           types.put(dic.getType(),new HashMap<String,String>());
        }
        for (TblSysDic dic1:list) {
            types.get(dic1.getType()).put(dic1.getParam(),dic1.getParamValue());
        }
        for (String key:types.keySet()) {
            ApplicationCache.getInstance().put(key, types.get(key));
        }
    }

    public static String getValue(String type,String key) {
        HashMap<String,String> dic = (HashMap<String, String>) ApplicationCache.getInstance().get(type);
        return  dic.get(key);
    }
}
