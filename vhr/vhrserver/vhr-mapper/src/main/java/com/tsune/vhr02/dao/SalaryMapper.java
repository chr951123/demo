package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Salary;
import com.tsune.vhr02.entity.SalaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryMapper {
    int countByExample(SalaryExample example);

    int deleteByExample(SalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    List<Salary> selectByExample(SalaryExample example);

    Salary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Salary record, @Param("example") SalaryExample example);

    int updateByExample(@Param("record") Salary record, @Param("example") SalaryExample example);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}