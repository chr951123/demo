package com.tsune.vhr02.service;

import com.tsune.vhr02.dao.PositionMapper;
import com.tsune.vhr02.entity.Position;
import com.tsune.vhr02.entity.PositionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionExample positionExample;
    @Autowired
    PositionMapper positionMapper;
    public List<Position> getAllPosition() {
        positionExample.clear();
        positionExample.createCriteria().andCreatedateIsNotNull();
        return positionMapper.selectByExample(positionExample);
    }


    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreatedate(new Date());
        return positionMapper.insert(position);
    }

    public int updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public int deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public int deletePositionByIds(List<Integer> ids) {
        positionExample.clear();
        positionExample.createCriteria().andIdIn(ids);
        return positionMapper.deleteByExample(positionExample);
    }
}
