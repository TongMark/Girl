package com.tree.service;

import com.tree.dto.Department;
import com.tree.dto.TreeView;

import java.util.List;

/**
 * Created by TFR on 2017/8/9.
 */
public interface IDepartmentService {

    Department add(Department department);

    List<TreeView> treeView();

    List<Department> selectAll();
}
