package org.dive.mapper;

import org.apache.ibatis.annotations.Select;
import org.dive.model.Teacher;

import java.util.List;

public interface TeacherMapper {
//    @Select("select * from teacher")
    List<Teacher> getTeachers();
}
