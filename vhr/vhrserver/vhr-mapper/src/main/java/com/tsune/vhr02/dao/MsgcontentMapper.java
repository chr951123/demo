package com.tsune.vhr02.dao;

import com.tsune.vhr02.entity.Msgcontent;
import com.tsune.vhr02.entity.MsgcontentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgcontentMapper {
    int countByExample(MsgcontentExample example);

    int deleteByExample(MsgcontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    List<Msgcontent> selectByExample(MsgcontentExample example);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Msgcontent record, @Param("example") MsgcontentExample example);

    int updateByExample(@Param("record") Msgcontent record, @Param("example") MsgcontentExample example);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}