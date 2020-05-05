package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Politicsstatus;
import com.tsune.vhr02.entity.PoliticsstatusExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticsstatusMapper {
    int countByExample(PoliticsstatusExample example);

    int deleteByExample(PoliticsstatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    List<Politicsstatus> selectByExample(PoliticsstatusExample example);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Politicsstatus record, @Param("example") PoliticsstatusExample example);

    int updateByExample(@Param("record") Politicsstatus record, @Param("example") PoliticsstatusExample example);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);
}