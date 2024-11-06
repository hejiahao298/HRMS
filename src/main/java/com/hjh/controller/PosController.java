package com.hjh.controller;

import com.hjh.dao.PosDao;
import com.hjh.entity.Position;
import com.hjh.entity.PositionVO;
import com.hjh.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PosController {
    @Autowired
    private PosDao posDao;

    @GetMapping("/pos/getAll")
    public Resp getAll(){
        List<Position> posAll = posDao.getAll();

        return Resp.success(posAll);
    }

    @GetMapping("/pos/getAllVO")
    public Resp getAllVO(){
        List<PositionVO> posAll = posDao.getAllVO();
        return Resp.success(posAll);
    }

    /**
     * 通过部门Id获取职位
     * @param departmentId 部门Id
     * @return 职位信息
     */
    @GetMapping("/pos/getPosByDep")
    public Resp getPosByDep(@RequestParam Integer departmentId){
        System.out.println(departmentId);
        List<PositionVO> posAll = posDao.getPosByDep(departmentId);
        return Resp.success(posAll);
    }

    /**
     * 添加职位信息
     * @param position 职位信息
     * @return 添加了几行数据
     */
    @PostMapping("/pos/addPos")
    public Resp addPos(@RequestBody Position position){
        Integer i = posDao.addPos(position);
        return Resp.success(i);
    }

    /**
     * 通过职位Id删除职位
     * @param posId 职位Id
     * @return 删除了几行数据
     */
    @DeleteMapping("/pos/deletePosById")
    public Resp deleteEmpById(@RequestParam Integer posId){
        Integer i = posDao.deletePosById(posId);
        return Resp.success(i);
    }
}
