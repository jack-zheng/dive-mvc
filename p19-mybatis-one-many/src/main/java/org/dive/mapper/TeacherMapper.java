package org.dive.mapper;

import org.dive.model.Teacher;

public interface TeacherMapper {
    Teacher getTeacherJoinTable(int id);

    Teacher getTeacherSubQuery(int id);
}
