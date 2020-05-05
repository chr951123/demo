package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Adjustsalary;
import com.tsune.vhr02.entity.AdjustsalaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdjustsalaryMapper {
    int countByExample(AdjustsalaryExample example);

    int deleteByExample(AdjustsalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    List<Adjustsalary> selectByExample(AdjustsalaryExample example);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByExample(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}