package org.dive;

import org.apache.ibatis.session.SqlSession;
import org.dive.mapper.TeacherMapper;
import org.dive.model.Teacher;
import org.junit.jupiter.api.Test;

public class TestOneToMany {
    private final SqlSession sqlSession = DBUtils.getSqlSession();

    @Test
    public void testSubQuery() {
        Teacher t = sqlSession.getMapper(TeacherMapper.class).getTeacherSubQuery(1);
        System.out.println(t);
    }

    @Test
    public void testJoinTable() {
        Teacher t = sqlSession.getMapper(TeacherMapper.class).getTeacherJoinTable(1);
        System.out.println(t);
    }
}
