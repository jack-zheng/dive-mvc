package org.dive;

import org.apache.ibatis.session.SqlSession;
import org.dive.dao.DepartmentsMapper;
import org.dive.model.Department;
import org.junit.jupiter.api.Test;

public class TestAnnotation {
    private final SqlSession sqlSession = DBUtils.getSqlSession();
    private final DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);

    @Test
    public void test() {
        mapper.getDepartments().forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        mapper.addDepartment(new Department("t001", "Test Department"));
        sqlSession.commit();
    }

    // update a department
    @Test
    public void testUpdate() {
        mapper.updateDepartment(new Department("t001", "Updated Test Department"));
        sqlSession.commit();
    }

    // get a department by deptNo
    @Test
    public void testRead() {
        System.out.println(mapper.getDepartmentByDeptNo("t001"));
    }

    // delete a department
    @Test
    public void testDelete() {
        mapper.deleteDepartment("t001");
        sqlSession.commit();
    }
}
