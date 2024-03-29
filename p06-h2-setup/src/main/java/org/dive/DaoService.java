package org.dive;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DaoService {
    private final JdbcTemplate jdbcTemplate;

    public DaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudent(Student student) {
        String sql = "INSERT INTO student (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getUsername(), student.getPassword());
    }

    public Student getStudentByUsername(String username) {
        String sql = "SELECT * FROM student WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username},
                new BeanPropertyRowMapper<>(Student.class));
    }
}
