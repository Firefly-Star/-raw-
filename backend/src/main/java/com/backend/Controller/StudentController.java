package com.backend.Controller;

import com.backend.Entity.*;
import com.backend.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081", "http://localhost:8082", "http://127.0.0.1:8082"})
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("api/students/display")
    Result DisplayAll()
    {
        List<StudentReturn> res = studentMapper.getStudentId();

        STDR stdr = new STDR();
        stdr.setList(res);
        return Result.Success(stdr);
    }

    @GetMapping("api/students/info")
    Result Displayteacher(@RequestParam int teacherId)
    {
        List<StudentReturn> res = studentMapper.getStudentIdByteacher(teacherId);
        STDR stdr = new STDR();
        stdr.setList(res);
        return Result.Success(stdr);
    }

    @PostMapping("api/access")
    Result Access(@RequestBody ts_Id ts)
    {
        studentMapper.updateStudentSubject(ts.getStudentId(), ts.getTopicId());
        return Result.Success("通过成功");
    }

    @PostMapping("api/refuse")
    Result Refuse(@RequestBody ts_Id ts)
    {
        studentMapper.updateStudentSubjectre(ts.getStudentId(), ts.getTopicId());
        return Result.Success("通过成功");
    }

    @PostMapping("api/student/submit")
    Result Submit(@RequestBody ststst studentId)
    {
        studentMapper.updateStudentwancheng(studentId.getStudentId());
        return Result.Success("已完成");
    }

    @GetMapping("api/displayToBeScored")
    Result DDD()
    {
        STDR stdr = new STDR();
        stdr.setList(studentMapper.asdfasdf());
        return Result.Success(null);
    }

    @PostMapping("api/scoring")
    Result DDDD(@RequestBody score_in sc)
    {
        System.out.println(sc);
        studentMapper.Score(sc.getStudentId(), sc.getScore());
        return Result.Success(null);
    }

    @GetMapping("api/displayScore")
    Result DDDDD(@RequestParam int studentId)
    {
        scc sc = new scc();
        sc.setScore(studentMapper.getScore(studentId));
        return Result.Success(sc);
    }

    @PostMapping("api/topics/byApply")
    Result DDDDDDD(@RequestBody byall topicId)
    {
        studentMapper.tongguo123(topicId.getTopicId());
        return Result.Success(null);
    }

}
