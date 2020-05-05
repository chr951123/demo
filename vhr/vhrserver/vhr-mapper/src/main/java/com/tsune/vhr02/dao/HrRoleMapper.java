package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.HrRole;
import com.tsune.vhr02.entity.HrRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrRoleMapper {
    int countByExample(HrRoleExample example);

    int deleteByExample(HrRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    List<HrRole> selectByExample(HrRoleExample example);

    HrRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByExample(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

}