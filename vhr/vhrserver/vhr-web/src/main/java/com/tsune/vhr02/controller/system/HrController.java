package com.tsune.vhr02.controller.system;

import com.tsune.vhr02.dao.HrMapper;
import com.tsune.vhr02.entity.Hr;
import com.tsune.vhr02.entity.RespBean;
import com.tsune.vhr02.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrMapper hrMapper;
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrMapper.updateByPrimaryKeySelective(hr)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrMapper.deleteByPrimaryKey(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
