package org.dive;

public interface StudentDao {
    void createStudent(Student user);
    void deleteStudent(String username);
    Student getStudentByUsername(String username);
}
