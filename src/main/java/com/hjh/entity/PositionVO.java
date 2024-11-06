package com.hjh.entity;

import lombok.Data;

@Data
public class PositionVO {
    private Integer positionId;
    private String positionTitle;
    private Integer departmentId;
    private String departmentName;
}
