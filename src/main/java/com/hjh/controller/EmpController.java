package com.hjh.controller;

import com.hjh.dao.EmpDao;
import com.hjh.dao.JobDao;
import com.hjh.entity.Employee;
import com.hjh.entity.EmployeeVO;
import com.hjh.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmpController {
    @Autowired
    private EmpDao empDao;

    @Autowired
    private JobDao jobDao;

    /**
     * 获取所有员工信息
     * @return 所有员工信息
     */
    @GetMapping("/emp/getAll")
    public Resp getAllEmp(){

        List<EmployeeVO> allEmployee = empDao.getAllEmp();
        System.out.println("所有员工信息："+allEmployee);
        return Resp.success(allEmployee);
    }

    /**
     * 通过名字模糊查询员工信息
     * @param name 员工名
     * @return 员工信息
     */
    @GetMapping("/emp/getEmpByName")
    public Resp getEmpByName(@RequestParam String name){
        List<EmployeeVO> empByName = empDao.getEmpByName(name);
        System.out.println("模糊查询的员工信息："+empByName);
        return Resp.success(empByName);
    }

    /**
     * 通过员工Id删除员工
     * @param empId 员工Id
     * @return 删除了几行数据
     */
    @DeleteMapping("/emp/deleteEmpById")
    public Resp deleteEmpById(@RequestParam Integer empId){
        Integer i = empDao.deleteEmpById(empId);
        return Resp.success(i);
    }

    /**
     * 根据员工Id获取员工信息，主要用户修改用户信息功能
     * @param empId 员工Id
     * @return 员工信息
     */
    @GetMapping("/emp/getEmpById")
    public Resp getEmpById(@RequestParam Integer empId){
        Employee emp = empDao.getEmpById(empId);
        System.out.println("更新前："+emp);
        return Resp.success(emp);
    }

    /**
     * 根据传来的员工信息，更新员工信息
     * @param employee 员工信息
     * @return 更新了几行数据
     */
    @PutMapping("/emp/updateEmp")
    public Resp updateEmp(@RequestBody Employee employee){
        System.out.println("更新后："+employee);
        Integer i = empDao.updateEmpById(employee);
        return Resp.success(i);
    }

    /**
     * 添加员工
     * @param employee 员工信息
     * @return 添加了几行数据
     */
    @PostMapping("/emp/addEmp")
    public Resp addEmp(@RequestBody Employee employee){
        System.out.println("添加的员工数据为："+employee);
        Integer i = empDao.addEmp(employee);
        return Resp.success(i);
    }

    /**
     * 首页渲染
     */
    @GetMapping("/emp/index")
    public Resp index(){
        Integer empCount = empDao.getEmpCount();
        Integer expiryCount = empDao.getExpiryCount();
        Integer jobCount = jobDao.getJobCount();
        Integer jobOpenings = jobDao.getJobOpenings();

        Map<String,Integer> map = new HashMap<>();
        map.put("empCount",empCount);
        map.put("expiryCount",expiryCount);
        map.put("jobCount",jobCount);
        map.put("jobOpenings",jobOpenings);

        return Resp.success(map);
    }
}
