package com.hjh.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeVO {
    private Integer employeeId;
    private String name;
    private String email;
    private String phone;
    private Date hireDate;
    private Date expiryDate;
    private String departmentName;
    private String positionTitle;
    private Float salary;
}
