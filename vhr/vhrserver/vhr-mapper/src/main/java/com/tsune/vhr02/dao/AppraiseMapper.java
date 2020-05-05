package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Appraise;
import com.tsune.vhr02.entity.AppraiseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppraiseMapper {
    int countByExample(AppraiseExample example);

    int deleteByExample(AppraiseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    List<Appraise> selectByExample(AppraiseExample example);

    Appraise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByExample(@Param("record") Appraise record, @Param("example") AppraiseExample example);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}