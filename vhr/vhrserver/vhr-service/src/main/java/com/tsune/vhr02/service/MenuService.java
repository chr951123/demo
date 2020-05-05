package com.tsune.vhr02.service;

import com.tsune.vhr02.dao.HrMapper;
import com.tsune.vhr02.dao.HrRoleMapper;
import com.tsune.vhr02.dao.MenuMapper;
import com.tsune.vhr02.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuExample menuExample;
    HrExample hrExample;
    HrMapper hrMapper;
    HrRoleExample hrRoleExample;
    HrRoleMapper hrRoleMapper;

    public List<Menu> getMenusByHrId() {
//        hrExample.createCriteria().andIdEqualTo(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
//        List<Hr> hrs = hrMapper.selectByExample(hrExample);
//        List<Integer> hrid = null;
//        for (Hr hr : hrs) {
//            hrid.add(hr.getId());
//        }
//        hrRoleExample.createCriteria().andHridIn(hrid);
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    public List<Menu> getAllMenuWithRole(){
        return menuMapper.getAllMenuWithRole();
    }
}
