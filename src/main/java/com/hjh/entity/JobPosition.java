package com.hjh.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class JobPosition {
    private Integer jobId;
    private Integer positionId;
    private Integer departmentId;
    private String description;
    private Integer openings;
    private String status;
    private Date postDate;
}