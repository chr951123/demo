package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Nation;
import com.tsune.vhr02.entity.NationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationMapper {
    int countByExample(NationExample example);

    int deleteByExample(NationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    List<Nation> selectByExample(NationExample example);

    Nation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nation record, @Param("example") NationExample example);

    int updateByExample(@Param("record") Nation record, @Param("example") NationExample example);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}