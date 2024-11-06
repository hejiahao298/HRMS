package com.hjh.dao;

import com.hjh.entity.JobPosition;
import com.hjh.entity.JobPositionVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobDao {

    // 查询所有招聘信息
    @Select("select * from JobPositionVO")
    public List<JobPositionVO> getAll();

    // 添加招聘信息
    @Insert("INSERT INTO JobPositions (position_id, department_id, description, openings, status, post_date) VALUES " +
            "(#{positionId}, #{departmentId}, #{description}, #{openings},#{status},#{postDate})")
    public Integer addJob(JobPosition jobPosition);

    // 删除招聘信息
    @Delete("delete from JobPositions where job_id = #{jobId}")
    public Integer deleteJobById(Integer jobId);

    // 根据部门名称或职位名称查询招聘信息
    @Select("select * from JobPositionVO where department_name = #{jobName} or position_title=#{jobName}")
    public List<JobPositionVO> getJobByName(String jobName);

    // 获取正在招聘的职位数
    @Select("select count(*) from JobPositions")
    public Integer getJobCount();

    // 获取需要招聘的总人数
    @Select("select sum(openings) from JobPositions")
    public Integer getJobOpenings();
}
