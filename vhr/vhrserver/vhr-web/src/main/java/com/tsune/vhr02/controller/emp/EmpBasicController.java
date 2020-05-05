package com.tsune.vhr02.controller.emp;

import com.tsune.vhr02.dao.*;
import com.tsune.vhr02.entity.*;
import com.tsune.vhr02.utils.POIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeExample employeeExample;
    @Autowired
    NationMapper nationMapper;
    @Autowired
    NationExample nationExample;
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    @Autowired
    PoliticsstatusExample politicsstatusExample;
    @Autowired
    JoblevelMapper joblevelMapper;
    @Autowired
    JoblevelExample joblevelExample;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    PositionExample positionExample;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    DepartmentExample departmentExample;
    @Autowired
    RabbitTemplate  rabbitTemplate;
    public final static Logger logger = LoggerFactory.getLogger(EmpBasicController.class);

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getAllEmpInfo(page, size, keywords);
        Long total = employeeMapper.getTotal(keywords);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeMapper.insertSelective(employee) == 1) {
            System.out.println("employee:"+employee);
            Employee emp = employeeMapper.getEmployeeById(employee.getId());
            System.out.println("emp:"+emp);
            logger.info(emp.toString());
            rabbitTemplate.convertAndSend("tsune.mail.welcome",emp);
            return RespBean.ok("添加成功");
        }
        return RespBean.ok("添加失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        nationExample.clear();
        nationExample.createCriteria().andIdIsNotNull();
        return nationMapper.selectByExample(nationExample);
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        politicsstatusExample.clear();
        politicsstatusExample.createCriteria().andIdIsNotNull();
        return politicsstatusMapper.selectByExample(politicsstatusExample);
    }

    @GetMapping("/joblevels")
    public List<Joblevel> getAllJoblevels() {
        joblevelExample.clear();
        joblevelExample.createCriteria().andIdIsNotNull();
        return joblevelMapper.selectByExample(joblevelExample);
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        positionExample.clear();
        positionExample.createCriteria().andIdIsNotNull();
        return positionMapper.selectByExample(positionExample);
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200).setObj(String.format("%08d", employeeMapper.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentByPid(-1);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = employeeMapper.getAllEmpInfo(null,null,null);
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        nationExample.clear();
        nationExample.createCriteria().andIdIsNotNull();
        politicsstatusExample.clear();
        politicsstatusExample.createCriteria().andIdIsNotNull();
        departmentExample.clear();
        departmentExample.createCriteria().andIdIsNotNull();
        positionExample.clear();
        positionExample.createCriteria().andIdIsNotNull();
        joblevelExample.clear();
        joblevelExample.createCriteria().andIdIsNotNull();
        List<Employee> list = POIUtils.excel2Employee(file, nationMapper.selectByExample(nationExample), politicsstatusMapper.selectByExample(politicsstatusExample), departmentMapper.selectByExample(departmentExample), positionMapper.selectByExample(positionExample), joblevelMapper.selectByExample(joblevelExample));
        if (employeeMapper.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
//        String path="C:\\Users\\TsuNe\\Desktop\\upload\\"+file.getOriginalFilename();
//        file.transferTo(new File(path));
////        file.transferTo(new File("C:\\Users\\TsuNe\\Desktop\\5.jpg"));
//        return RespBean.ok("上传成功");
//    }
}
