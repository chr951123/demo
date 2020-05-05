package com.tsune.vhr02.controller.system.basic;

import com.tsune.vhr02.entity.Position;
import com.tsune.vhr02.entity.RespBean;
import com.tsune.vhr02.service.PositionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPosition() {
        return positionService.getAllPosition();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(@Param("ids") Integer[] ids) {
        List<Integer> idList = CollectionUtils.arrayToList(ids);
        if (positionService.deletePositionByIds(idList) == idList.size()) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
