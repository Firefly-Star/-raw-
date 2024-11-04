package com.backend.Mapper;

import com.backend.Entity.Student;
import com.backend.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM student WHERE " +
            "uname = #{uname} and pword = #{pword}")
    Student studentLogin(Student student);

    @Select("SELECT * FROM teacher WHERE " +
            "uname = #{uname} and pword = #{pword}")
    Teacher teacherLogin(Teacher teacher);
}
