package com.backend.Mapper;

import com.backend.Entity.Assessor;
import com.backend.Entity.Council;
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

    @Select("SELECT * FROM council WHERE " +
            "uname = #{uname} and pword = #{pword}")
    Council councilLogin(Council council);

    @Select("SELECT * FROM assessor WHERE " +
            "uname = #{uname} and pword = #{pword}")
    Assessor assessorLogin(Assessor assessor);
}
