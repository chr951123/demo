package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Employeeec;
import com.tsune.vhr02.entity.EmployeeecExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeecMapper {
    int countByExample(EmployeeecExample example);

    int deleteByExample(EmployeeecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    List<Employeeec> selectByExample(EmployeeecExample example);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeeec record, @Param("example") EmployeeecExample example);

    int updateByExample(@Param("record") Employeeec record, @Param("example") EmployeeecExample example);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}