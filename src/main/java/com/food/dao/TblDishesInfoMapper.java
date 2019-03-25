package com.food.dao;

import com.food.entity.TblDishesInfo;
import com.food.entity.TblDishesInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblDishesInfoMapper {
    int countByExample(TblDishesInfoExample example);

    int deleteByExample(TblDishesInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblDishesInfo record);

    int insertSelective(TblDishesInfo record);

    List<TblDishesInfo> selectByExample(TblDishesInfoExample example);

    TblDishesInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblDishesInfo record, @Param("example") TblDishesInfoExample example);

    int updateByExample(@Param("record") TblDishesInfo record, @Param("example") TblDishesInfoExample example);

    int updateByPrimaryKeySelective(TblDishesInfo record);

    int updateByPrimaryKey(TblDishesInfo record);
}