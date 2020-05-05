package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Sysmsg;
import com.tsune.vhr02.entity.SysmsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysmsgMapper {
    int countByExample(SysmsgExample example);

    int deleteByExample(SysmsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    List<Sysmsg> selectByExample(SysmsgExample example);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByExample(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}