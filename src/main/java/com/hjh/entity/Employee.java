package com.hjh.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Employee {
    private Integer employeeId;
    private String name;
    private String email;
    private String phone;
    private Date hireDate;
    private Date expiryDate;
    private Integer departmentId;
    private Integer positionId;
    private Float salary;
}
