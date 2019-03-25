package com.food.dao;

import com.food.entity.TblFoodTable;
import com.food.entity.TblFoodTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblFoodTableMapper {
    int countByExample(TblFoodTableExample example);

    int deleteByExample(TblFoodTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblFoodTable record);

    int insertSelective(TblFoodTable record);

    List<TblFoodTable> selectByExample(TblFoodTableExample example);

    TblFoodTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblFoodTable record, @Param("example") TblFoodTableExample example);

    int updateByExample(@Param("record") TblFoodTable record, @Param("example") TblFoodTableExample example);

    int updateByPrimaryKeySelective(TblFoodTable record);

    int updateByPrimaryKey(TblFoodTable record);
}