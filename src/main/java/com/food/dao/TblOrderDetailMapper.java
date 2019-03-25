package com.food.dao;

import com.food.entity.TblOrderDetail;
import com.food.entity.TblOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrderDetailMapper {
    int countByExample(TblOrderDetailExample example);

    int deleteByExample(TblOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblOrderDetail record);

    int insertSelective(TblOrderDetail record);

    List<TblOrderDetail> selectByExample(TblOrderDetailExample example);

    TblOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblOrderDetail record, @Param("example") TblOrderDetailExample example);

    int updateByExample(@Param("record") TblOrderDetail record, @Param("example") TblOrderDetailExample example);

    int updateByPrimaryKeySelective(TblOrderDetail record);

    int updateByPrimaryKey(TblOrderDetail record);
}