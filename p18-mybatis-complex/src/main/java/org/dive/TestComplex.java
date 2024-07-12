package org.dive;

import org.apache.ibatis.session.SqlSession;
import org.dive.mapper.StudentMapper;
import org.dive.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;

public class TestComplex {
    private final SqlSession sqlSession = DBUtils.getSqlSession();

    @Test
    public void test() {
        sqlSession.getMapper(TeacherMapper.class).getTeachers().forEach(System.out::println);
    }

    @Test
    public void testComplexSubQuery() {
        sqlSession.getMapper(StudentMapper.class).getStudentsSubQuery().forEach(System.out::println);
    }

    @Test
    public void testComplexJoinTable() {
        sqlSession.getMapper(StudentMapper.class).getStudentsJoinTable().forEach(System.out::println);
    }
}
