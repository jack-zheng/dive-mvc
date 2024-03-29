package org.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createStudent(Student user) {
        String sql = "INSERT INTO student (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteStudent(String username) {
        String sql = "DELETE FROM student WHERE username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public Student getStudentByUsername(String username) {
        String sql = "SELECT * FROM student WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username},
                new BeanPropertyRowMapper<>(Student.class));
    }
}
