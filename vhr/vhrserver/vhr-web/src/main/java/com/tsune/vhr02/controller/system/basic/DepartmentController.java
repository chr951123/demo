package com.tsune.vhr02.controller.system.basic;

import com.tsune.vhr02.dao.DepartmentMapper;
import com.tsune.vhr02.dao.EmployeeMapper;
import com.tsune.vhr02.entity.Department;
import com.tsune.vhr02.entity.DepartmentExample;
import com.tsune.vhr02.entity.EmployeeExample;
import com.tsune.vhr02.entity.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    List<Department> allDepartments = new ArrayList<>();
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    DepartmentExample departmentExample;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeExample employeeExample;

    @GetMapping("/")
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartmentByPid(-1);
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department department) {
        department.setEnabled(true);
        department.setIsparent(false);
        Department parentDep = departmentMapper.selectByPrimaryKey(department.getParentid());
        String parentDeppath = parentDep.getDeppath();
        if (departmentMapper.insert(department) == 1) {
            department.setDeppath(parentDeppath + "." + department.getId());
            if (departmentMapper.updateByPrimaryKeySelective(department) == 1) {
                if (parentDep.getIsparent() == false) {
                    parentDep.setIsparent(true);
                    if (departmentMapper.updateByPrimaryKeySelective(parentDep) == 1) {
                        return RespBean.ok("添加成功", department);
                    }
                } else {
                    return RespBean.ok("添加成功", department);
                }
            }
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id){
        Department department = departmentMapper.selectByPrimaryKey(id);
        if (department.getIsparent()==true){
            return RespBean.error("无法删除父部门！");
        }else {
            employeeExample.clear();
            employeeExample.createCriteria().andDepartmentidEqualTo(department.getId());
            if (employeeMapper.selectByExample(employeeExample).size()>0){
                return RespBean.error("该部门有员工，无法删除！！");
            }else {
                Department parentDep = departmentMapper.selectByPrimaryKey(department.getParentid());
                departmentExample.clear();
                departmentExample.createCriteria().andParentidEqualTo(department.getParentid());
                if (departmentMapper.selectByExample(departmentExample).size()>1){
                    if (departmentMapper.deleteByPrimaryKey(department.getId())==1){
                        return RespBean.ok("删除成功！");
                    }else {
                        return RespBean.error("删除失败！");
                    }
                }else {
                    parentDep.setIsparent(false);
                    if (departmentMapper.updateByPrimaryKeySelective(parentDep)==1&&departmentMapper.deleteByPrimaryKey(department.getId())==1){
                        return RespBean.ok("删除成功！");
                    }else {
                        return RespBean.error("删除失败！");
                    }
                }
            }
        }
    }
}
