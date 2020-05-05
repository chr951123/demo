package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Oplog;
import com.tsune.vhr02.entity.OplogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OplogMapper {
    int countByExample(OplogExample example);

    int deleteByExample(OplogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    List<Oplog> selectByExample(OplogExample example);

    Oplog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByExample(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}