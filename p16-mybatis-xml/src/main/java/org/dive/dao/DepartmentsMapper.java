package org.dive.dao;

import org.dive.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentsMapper {
    List<Department> getDepartments();

    // add new department
    int addDepartment(Department department);

    // delete a department
    int deleteDepartment(String deptNo);

    // update a department
    int updateDepartment(Department department);

    // get a department by deptNo
    Department getDepartmentByDeptNo(String deptNo);

    List<Department> getPagedDepartments(Map<String, Integer> map);
}
