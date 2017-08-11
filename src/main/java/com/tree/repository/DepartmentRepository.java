package com.tree.repository;

import com.tree.dto.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TFR on 2017/8/9.
 */
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
