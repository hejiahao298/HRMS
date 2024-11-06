package com.hjh.controller;

import com.hjh.dao.JobDao;
import com.hjh.entity.JobPosition;
import com.hjh.entity.JobPositionVO;
import com.hjh.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobDao jobDao;

    /**
     * 获取所有招聘信息
     * @return 招聘信息
     */
    @GetMapping("/job/getAll")
    public Resp getAll(){
        List<JobPositionVO> jobAll = jobDao.getAll();
        System.out.println("所有招聘信息为："+jobAll);
        return Resp.success(jobAll);
    }

    /**
     * 添加招聘信息
     * @param jobPosition 招聘信息
     * @return 添加了几行数据
     */
    @PostMapping("/job/addJob")
    public Resp addJob(@RequestBody JobPosition jobPosition){
        System.out.println("添加一个招聘信息"+jobPosition);
        Integer i = jobDao.addJob(jobPosition);
        return Resp.success(i);
    }

    /**
     * 删除招聘信息
     * @param jobId 招聘Id
     * @return 删除了几行数据
     */
    @DeleteMapping("/job/deleteJobById")
    public Resp deleteJobById(@RequestParam Integer jobId){
        Integer i = jobDao.deleteJobById(jobId);
        return Resp.success(i);
    }

    /**
     * 根据部门名称或职位名称查询招聘信息
     * @param jobName 名称
     * @return 招聘信息
     */
    @GetMapping("/job/getJobByName")
    public Resp getJobByName(@RequestParam String jobName){
        List<JobPositionVO> jobByName = jobDao.getJobByName(jobName);
        System.out.println("查询到的招聘信息"+jobByName);
        return Resp.success(jobByName);
    }
}
