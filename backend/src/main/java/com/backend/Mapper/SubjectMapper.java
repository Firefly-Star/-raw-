package com.backend.Mapper;

import com.backend.Entity.Subject;
import com.backend.Entity.SubjectDisplay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubjectMapper {


    @Options(useGeneratedKeys = true, keyProperty = "topicId")
    @Insert("INSERT INTO subject(subjectName, subjectType, description, teacherId) " +
            "values (#{topicName}, #{topicType}, #{description}, #{teacherId})")
    void insertSubject(Subject subject);

    @Delete("DELETE FROM subject " +
            "where subjectId = #{topicId}")
    void deleteSubject(Long topicId);

    @Select("SELECT t.teacherName, s.subjectName, s.subjectType, s.description, s.state AS applyStatus, s.subjectId AS topicId" +
            " FROM subject s inner join teacher t on s.teacherId = t.teacherId" )
    @Results({
            @Result(column = "teacherName", property = "teacherName"),
            @Result(column = "subjectName", property = "topicName"),
            @Result(column = "subjectType", property = "topicType"),
            @Result(column = "description", property = "description")
    })
    List<SubjectDisplay> selectAllsubject();

    @Select("SELECT t.teacherName, s.subjectName as topicName, s.subjectType as topicType, s.description, ss.subjectId as topicId" +
            " FROM subject s inner join teacher t on s.teacherId = t.teacherId" +
            " inner join student_subject ss on s.subjectId = ss.subjectId" +
            " where ss.studentId = #{studentId} and ss.state = #{state}")
    List<SubjectDisplay> selectAllsubjectByStudent(Integer studentId, String state);

    @Select("SELECT t.teacherName, s.subjectName as topicName, s.subjectType as topicType, s.description as description, s.state AS applyStatus, s.subjectId AS topicId" +
            " FROM subject s inner join teacher t on s.teacherId = t.teacherId" +
            " where s.state = '已申请'" )
    List<SubjectDisplay> selectAllsubjectByTeacher();

}
