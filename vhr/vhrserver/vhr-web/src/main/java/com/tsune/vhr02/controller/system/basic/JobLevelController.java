package com.tsune.vhr02.controller.system.basic;

import com.tsune.vhr02.dao.JoblevelMapper;
import com.tsune.vhr02.entity.Joblevel;
import com.tsune.vhr02.entity.JoblevelExample;
import com.tsune.vhr02.entity.RespBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JoblevelMapper joblevelMapper;
    @Autowired
    JoblevelExample joblevelExample;
    @GetMapping("/")
    public List<Joblevel> getAllJobLevel(){
        joblevelExample.clear();
        joblevelExample.createCriteria().andIdIsNotNull();
        return joblevelMapper.selectByExample(joblevelExample);
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        if (joblevelMapper.insertSelective(joblevel)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        if (joblevelMapper.updateByPrimaryKeySelective(joblevel)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id){
        if (joblevelMapper.deleteByPrimaryKey(id)== 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids){
        List<Integer> idList = CollectionUtils.arrayToList(ids);
        joblevelExample.clear();
        joblevelExample.createCriteria().andIdIn(idList);
        if (joblevelMapper.deleteByExample(joblevelExample) == idList.size()) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
