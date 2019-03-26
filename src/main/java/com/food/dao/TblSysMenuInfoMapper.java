package com.food.dao;

import com.food.entity.TblSysMenuInfo;
import com.food.entity.TblSysMenuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSysMenuInfoMapper {
    int countByExample(TblSysMenuInfoExample example);

    int deleteByExample(TblSysMenuInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblSysMenuInfo record);

    int insertSelective(TblSysMenuInfo record);

    List<TblSysMenuInfo> selectByExample(TblSysMenuInfoExample example);

    TblSysMenuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblSysMenuInfo record, @Param("example") TblSysMenuInfoExample example);

    int updateByExample(@Param("record") TblSysMenuInfo record, @Param("example") TblSysMenuInfoExample example);

    int updateByPrimaryKeySelective(TblSysMenuInfo record);

    int updateByPrimaryKey(TblSysMenuInfo record);

}