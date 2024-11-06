package com.hjh.dao;

import com.hjh.entity.Department;
import com.hjh.entity.DepartmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepDao {

    // 查询所有部门的信息
    @Select("select * from Departments")
    public List<Department> getAll();

    // 查询部门视图信息
    @Select("select * from DepartmentVO")
    public List<DepartmentVO> getAllDepVO();
}
