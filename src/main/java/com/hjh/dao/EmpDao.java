package com.hjh.dao;

import com.hjh.entity.Employee;
import com.hjh.entity.EmployeeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpDao {

    // 查询视图EmployeeVO，查询所有员工信息
    @Select("SELECT * from EmployeeVO")
    public List<EmployeeVO> getAllEmp();

    // 根据员工名进行模糊查询
    @Select("select * from EmployeeVO WHERE name LIKE CONCAT('%', #{name}, '%')")
    public List<EmployeeVO> getEmpByName(String name);

    // 根据员工Id删除员工
    @Delete("delete from Employees where employee_id = #{empId}")
    public Integer deleteEmpById(Integer empId);

    // 根据员工Id，查询员工信息，视图Employee
    @Select("select * from Employees WHERE employee_id = #{empId}")
    public Employee getEmpById(Integer empId);

    // 更新员工数据
    @Update("update Employees " +
            "set name=#{name},email=#{email}," +
            "phone=#{phone},hire_date=#{hireDate}," +
            "expiry_date=#{expiryDate},department_id=#{departmentId}," +
            "position_id=#{positionId},salary=#{salary} " +
            "where employee_id = #{employeeId}")
    public Integer updateEmpById(Employee employee);

    // 添加员工
    @Insert("INSERT INTO Employees (name, email, phone, hire_date, expiry_date, department_id, position_id, salary) " +
            "VALUES(#{name}, #{email}, #{phone}, #{hireDate}, #{expiryDate}, #{departmentId},#{positionId},#{salary})")
    public Integer addEmp(Employee employee);

    // 员工总数
    @Select("select count(*) from Employees")
    public Integer getEmpCount();

    // 查询员工合同到期的员工数
    @Select("SELECT COUNT(*) FROM Employees WHERE expiry_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)")
    public Integer getExpiryCount();
}
