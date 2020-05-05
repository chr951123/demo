package com.tsune.vhr02.controller.system.basic;

import com.tsune.vhr02.dao.MenuMapper;
import com.tsune.vhr02.dao.MenuRoleMapper;
import com.tsune.vhr02.dao.RoleMapper;
import com.tsune.vhr02.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleExample roleExample;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    @Autowired
    MenuRoleExample menuRoleExample;


    @GetMapping("/")
    public List<Role> getAllRoles() {
        roleExample.clear();
        roleExample.createCriteria().andIdIsNotNull();
        return roleMapper.selectByExample(roleExample);
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {
        List<Integer> mids = new ArrayList<>();
        menuRoleExample.clear();
        ;
        menuRoleExample.createCriteria().andRidEqualTo(rid);
        List<MenuRole> menuRoles = menuRoleMapper.selectByExample(menuRoleExample);
        for (MenuRole menuRole : menuRoles) {
            mids.add(menuRole.getMid());
        }
        return mids;
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        int i = 0;
        menuRoleExample.clear();
        menuRoleExample.createCriteria().andRidEqualTo(rid);
        menuRoleMapper.deleteByExample(menuRoleExample);
        if (mids.length != 0) {
            for (Integer mid : mids) {
                MenuRole menuRole = new MenuRole();
                menuRole.setRid(rid);
                menuRole.setMid(mid);
                if (menuRoleMapper.insert(menuRole) == 1)
                    i++;
            }
        }
        if (i == mids.length) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        if (roleMapper.insert(role) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRoleById(@PathVariable Integer id){
        if (roleMapper.deleteByPrimaryKey(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败");
    }
}
