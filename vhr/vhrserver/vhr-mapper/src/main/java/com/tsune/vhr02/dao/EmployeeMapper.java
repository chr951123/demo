package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Employee;
import com.tsune.vhr02.entity.EmployeeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getAllEmpInfo(@Param("page") Integer page, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getTotal(String keywords);

    Integer maxWorkID();

    Employee getEmployeeById(Integer id);

    int addEmps(List<Employee> list);
}