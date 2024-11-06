package com.hjh.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class JobPositionVO {
    private Integer jobId;
    private String positionTitle;
    private String departmentName;
    private String description;
    private Integer openings;
    private String status;
    private Date postDate;
}
