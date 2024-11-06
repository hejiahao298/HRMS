package com.hjh.controller;

import com.hjh.dao.DepDao;
import com.hjh.entity.Department;
import com.hjh.entity.DepartmentVO;
import com.hjh.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepController {

    @Autowired
    private DepDao depDao;

    @GetMapping("/dep/getAll")
    public Resp getAll(){
        List<Department> depAll = depDao.getAll();

        return Resp.success(depAll);
    }

    /**
     * 查询所有部门信息
     * @return 所有部门信息
     */
    @GetMapping("/dep/getAllDepVO")
    public Resp getAllDepVO(){
        List<DepartmentVO> allDepVO = depDao.getAllDepVO();
        return Resp.success(allDepVO);
    }
}
