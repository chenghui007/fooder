package com.food.dao;

import com.food.entity.TblUserInfo;
import com.food.entity.TblUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserInfoMapper {
    int countByExample(TblUserInfoExample example);

    int deleteByExample(TblUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblUserInfo record);

    int insertSelective(TblUserInfo record);

    List<TblUserInfo> selectByExample(TblUserInfoExample example);

    TblUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblUserInfo record, @Param("example") TblUserInfoExample example);

    int updateByExample(@Param("record") TblUserInfo record, @Param("example") TblUserInfoExample example);

    int updateByPrimaryKeySelective(TblUserInfo record);

    int updateByPrimaryKey(TblUserInfo record);
}