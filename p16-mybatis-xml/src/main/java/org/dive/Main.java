package org.dive;

import org.apache.ibatis.session.SqlSession;
import org.dive.dao.DepartmentsMapper;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = DBUtils.getSqlSession();
        sqlSession.getMapper(DepartmentsMapper.class).getDepartments().forEach(System.out::println);
    }
}