package com.food.dao;

import com.food.entity.TblSysDic;
import com.food.entity.TblSysDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSysDicMapper {
    int countByExample(TblSysDicExample example);

    int deleteByExample(TblSysDicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblSysDic record);

    int insertSelective(TblSysDic record);

    List<TblSysDic> selectByExample(TblSysDicExample example);

    TblSysDic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblSysDic record, @Param("example") TblSysDicExample example);

    int updateByExample(@Param("record") TblSysDic record, @Param("example") TblSysDicExample example);

    int updateByPrimaryKeySelective(TblSysDic record);

    int updateByPrimaryKey(TblSysDic record);
}