package com.backend.Mapper;

import com.backend.Entity.Apply;
import com.backend.Entity.TeacherReturn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select teacherId, teacherName, uname as tuname, pword as tpword, phoneNumber as contactInfo, remark" +
            " from teacher")
    List<TeacherReturn> selectAll();

    @Select("select t.teacherId, t.teacherName, t.phoneNumber as contactInfo, t.remark" +
            " from teacher t inner join subject s on t.teacherId = s.teacherId" +
            " where s.subjectId = #{id}")
    TeacherReturn selectById(Integer id);

    @Insert("insert into student_subject(studentId, subjectId, councilId, pass, state)" +
            " values (#{studentId}, #{subjectId}, 1, 0, '已申请')")
    void insert(Integer subjectId, Integer studentId);
}
