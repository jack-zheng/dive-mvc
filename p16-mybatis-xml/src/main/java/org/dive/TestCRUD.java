package org.dive;

import org.apache.ibatis.session.SqlSession;
import org.dive.dao.DepartmentsMapper;
import org.dive.model.Department;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestCRUD {
    private final SqlSession sqlSession = DBUtils.getSqlSession();
    private final DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

    @Test
    public void testGetList() {
        mapper.getDepartments().forEach(System.out::println);
    }

    // test get
    @Test
    public void testRead() {
        System.out.println(mapper.getDepartmentByDeptNo("d001"));
    }

    // test add
    @Test
    public void testAdd() {
        Department department = new Department();
        department.setDeptNo("t001");
        department.setDeptName("Test Department");
        mapper.addDepartment(department);

        sqlSession.commit();
    }

    // test update
    @Test
    public void testUpdate() {
        Department department = new Department();
        department.setDeptNo("t001");
        department.setDeptName("Updated Test Department");
        Object ret = mapper.updateDepartment(department);
        System.out.println(ret);

        sqlSession.commit();
    }

    // delete a department
    @Test
    public void testDelete() {
        Object ret = mapper.deleteDepartment("t001");
        System.out.println(ret);

        sqlSession.commit();
    }

    // test paging
    @Test
    public void testPaging() {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 2);

        mapper.getPagedDepartments(map).forEach(System.out::println);
    }
}
