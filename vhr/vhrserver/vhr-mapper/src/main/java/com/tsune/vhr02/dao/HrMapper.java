package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Hr;
import com.tsune.vhr02.entity.HrExample;
import com.tsune.vhr02.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {
    int countByExample(HrExample example);

    int deleteByExample(HrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    List<Hr> selectByExample(HrExample example);

    Hr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hr record, @Param("example") HrExample example);

    int updateByExample(@Param("record") Hr record, @Param("example") HrExample example);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer id, @Param("keywords") String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);
}