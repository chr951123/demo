package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Joblevel;
import com.tsune.vhr02.entity.JoblevelExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoblevelMapper {
    int countByExample(JoblevelExample example);

    int deleteByExample(JoblevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    List<Joblevel> selectByExample(JoblevelExample example);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByExample(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
}