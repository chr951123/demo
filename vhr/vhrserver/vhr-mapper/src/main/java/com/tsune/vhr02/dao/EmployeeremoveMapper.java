package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Employeeremove;
import com.tsune.vhr02.entity.EmployeeremoveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeremoveMapper {
    int countByExample(EmployeeremoveExample example);

    int deleteByExample(EmployeeremoveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    List<Employeeremove> selectByExample(EmployeeremoveExample example);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeeremove record, @Param("example") EmployeeremoveExample example);

    int updateByExample(@Param("record") Employeeremove record, @Param("example") EmployeeremoveExample example);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);
}