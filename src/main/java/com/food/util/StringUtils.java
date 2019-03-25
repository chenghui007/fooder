package com.food.util;

/**
 * Created by chenghui on 2019/3/23.
 */
public class StringUtils {


        public  static  boolean  isEmpty(String str){
            if(str==null || str.equals("")){
                return true;
            }
            return false;
        }
}
