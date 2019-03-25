package com.food.dao;

import com.food.entity.TblSysUser;
import com.food.entity.TblSysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSysUserMapper {
    int countByExample(TblSysUserExample example);

    int deleteByExample(TblSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblSysUser record);

    int insertSelective(TblSysUser record);

    List<TblSysUser> selectByExample(TblSysUserExample example);

    TblSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblSysUser record, @Param("example") TblSysUserExample example);

    int updateByExample(@Param("record") TblSysUser record, @Param("example") TblSysUserExample example);

    int updateByPrimaryKeySelective(TblSysUser record);

    int updateByPrimaryKey(TblSysUser record);
}