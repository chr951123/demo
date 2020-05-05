package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.MenuRole;
import com.tsune.vhr02.entity.MenuRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRoleMapper {
    int countByExample(MenuRoleExample example);

    int deleteByExample(MenuRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    List<MenuRole> selectByExample(MenuRoleExample example);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuRole record, @Param("example") MenuRoleExample example);

    int updateByExample(@Param("record") MenuRole record, @Param("example") MenuRoleExample example);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);
}