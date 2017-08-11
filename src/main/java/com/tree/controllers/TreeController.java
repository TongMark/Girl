package com.tree.controllers;

import com.tfr.dto.Result;
import com.tfr.util.ResultUtil;
import com.tree.dto.Depart;
import com.tree.dto.Department;
import com.tree.dto.TreeView;
import com.tree.service.IDepartService;
import com.tree.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TFR on 2017/8/4.
 */
@RestController
public class TreeController {

    @Autowired
    private IDepartService departService;

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping(value = "/tree/insert")
    public Result<Depart> insertData(Depart depart){
        return ResultUtil.success(departService.insertDepart(depart));
    }

    @GetMapping(value = "/tree/d")
    public Result<List<TreeView>> ddd(){
        return ResultUtil.success(departService.treeView());
    }

    @PostMapping(value = "/depart/insert")
    public Result<Department> insertDepartData(Department department){
        return ResultUtil.success(departmentService.add(department));
    }
    @GetMapping(value = "/tree/t")
    public Result<List<TreeView>> test(){
        return ResultUtil.success(departmentService.treeView());
    }

}
