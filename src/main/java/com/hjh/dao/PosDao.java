package com.hjh.dao;

import com.hjh.entity.Position;
import com.hjh.entity.PositionVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PosDao {

    @Select("select * from Positions")
    public List<Position> getAll();

    @Select("select * from PositionVO")
    public List<PositionVO> getAllVO();

    // 通过部门号查询职位
    @Select("select * from PositionVO where department_Id = #{departmentId}")
    public List<PositionVO> getPosByDep(Integer departmentId);

    // 添加职位
    @Insert("insert into Positions(position_title,department_id) values (#{positionTitle},#{departmentId})")
    public Integer addPos(Position position);

    // 根据职位Id删除职位
    @Delete("delete from Positions where position_id = #{posId}")
    public Integer deletePosById(Integer posId);
}
