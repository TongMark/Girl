package com.tree.service.impl;

import com.tree.dto.Department;
import com.tree.dto.TreeView;
import com.tree.repository.DepartmentRepository;
import com.tree.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TFR on 2017/8/9.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department add(Department department) {
        return repository.save(department);
    }

    @Override
    public List<TreeView> treeView() {
        List<Department> departments = repository.findAll();
        return createTree(departments,0);
    }
    //递归树结构数据
    public List<TreeView> createTree(List<Department> departments,Integer Id){
        List<TreeView> treeViews = new ArrayList<>();
        if(departments.size() != 0){
            for(Department department : departments){
                if (department.getParentId() == Id){
                    TreeView treeView = new TreeView();
                    treeView.setName(department.getDepartName());
                    treeView.setChildren(createTree(departments,department.getId()));//递归
                    treeViews.add(treeView);
                }
            }
        }
        return treeViews;
    }

    @Override
    public List<Department> selectAll() {
        return repository.findAll();
    }
}
