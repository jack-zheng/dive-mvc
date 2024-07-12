package org.dive.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.dive.model.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentsMapper {
    @Select("select * from departments")
    List<Department> getDepartments();

    // create a new department
    @Insert("insert into departments(dept_no, dept_name) values(#{deptNo}, #{deptName})")
    int addDepartment(Department department);

    // update a department
    @Update("update departments set dept_name = #{deptName} where dept_no = #{deptNo}")
    int updateDepartment(Department department);

    // get a department by deptNo
    @Select("select * from departments where dept_no = #{deptNo}")
    Department getDepartmentByDeptNo(@Param("deptNo") String deptNo);

    // delete a department
    @Delete("delete from departments where dept_no = #{deptNo}")
    int deleteDepartment(String deptNo);
}
