package com.food.dao;

import com.food.entity.TblOrderInfo;
import com.food.entity.TblOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrderInfoMapper {
    int countByExample(TblOrderInfoExample example);

    int deleteByExample(TblOrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblOrderInfo record);

    int insertSelective(TblOrderInfo record);

    List<TblOrderInfo> selectByExample(TblOrderInfoExample example);

    TblOrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblOrderInfo record, @Param("example") TblOrderInfoExample example);

    int updateByExample(@Param("record") TblOrderInfo record, @Param("example") TblOrderInfoExample example);

    int updateByPrimaryKeySelective(TblOrderInfo record);

    int updateByPrimaryKey(TblOrderInfo record);
}