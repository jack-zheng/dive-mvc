package org.dive.mapper;

import org.dive.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentsSubQuery();

    List<Student> getStudentsJoinTable();
}
