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

    @Select("SELECT t.teacherName, s.subjectName, s.subjectType, s.description" +
            " FROM subject s inner join teacher t on s.teacherId = t.teacherId")
    @Results({
            @Result(column = "teacherName", property = "teacherName"),
            @Result(column = "subjectName", property = "topicName"),
            @Result(column = "subjectType", property = "topicType"),
            @Result(column = "description", property = "description")
    })
    List<SubjectDisplay> selectAllsubject();

}
