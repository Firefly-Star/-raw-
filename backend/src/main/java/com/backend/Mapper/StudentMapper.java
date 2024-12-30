package com.backend.Mapper;

import com.backend.Entity.StudentReturn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT student.studentId, studentName, pword as spword, uname as suname, phoneNumber as contactInfo, resume " +
            "from student")
    List<StudentReturn> getStudentId();

    @Select("SELECT s.studentId, s.studentName, s.pword as spword, s.uname as suname, s.phoneNumber as contactInfo, s.resume " +
            " from student s inner join student_subject ss on s.studentId = ss.studentId " +
            " inner join subject su on ss.subjectId = su.subjectId" +
            " where su.teacherId = #{teacherId}")
    List<StudentReturn> getStudentIdByteacher(Integer teacherId);

    @Update("UPDATE student_subject ss " +
            "SET state = '已通过' " +
            "where ss.studentId = #{studentId} and ss.subjectId = #{subjectId} and ss.state = '已申请'")
    void updateStudentSubject(Integer studentId, Integer subjectId);

    @Update("UPDATE student_subject ss " +
            "SET state = '已拒绝' " +
            "where ss.studentId = #{studentId} and ss.subjectId = #{subjectId} and ss.state = '已申请'")
    void updateStudentSubjectre(Integer studentId, Integer subjectId);

    @Update("UPDATE student_subject ss " +
            "SET state = '已完成' " +
            "where ss.studentId = #{studentId} and ss.state = '已通过'")
    void updateStudentwancheng(Integer studentId);

    @Select("SELECT s.studentId, s.studentName, s.phoneNumber as contactInfo " +
            " from student s inner join student_subject ss on s.studentId = ss.studentId" +
            " where ss.state = '已完成'")
    List<StudentReturn> asdfasdf();

    @Update("UPDATE student_subject " +
            "set score = #{score} " +
            "where studentId = #{studentId} and state = '已完成'")
    void Score(Integer studentId, Integer score);

    @Select("SELECT student_subject.score " +
            "from student_subject " +
            "where studentId = #{studentId} and state = '已完成'")
    int getScore(Integer studentId);

    @Update("UPDATE subject " +
            "set state = '已通过' " +
            "where subjectId = #{subjectId}")
    int tongguo123(Integer subjectId);
}
