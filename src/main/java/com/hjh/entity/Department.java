package com.hjh.entity;

import lombok.Data;

@Data
public class Department {
    private Integer departmentId;
    private String departmentName;
    private Integer leaderId;
}