package com.backend.Controller;

import com.backend.Entity.*;
import com.backend.Mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topics")
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081", "http://localhost:8082", "http://127.0.0.1:8082"})
public class SubjectController {

    @Autowired
    SubjectMapper subjectMapper;


    @PostMapping("add")
    Result AddSubject(@RequestBody Subject subject)
    {
        subjectMapper.insertSubject(subject);
        if(subject.getTopicId() == null)
        {
            return Result.Failure("failed to add subject");
        }
        else
        {
            SubjectId temp = new SubjectId(subject.getTopicId());
            return Result.Success(temp);
        }
    }

    @DeleteMapping("delete/{topicId}")
    Result DeleteSubject(@PathVariable("topicId") Long topicId)
    {
        subjectMapper.deleteSubject(topicId);
        return Result.Success("deleted subject");
    }

    @GetMapping("display")
    Result DisplaySubjectAll()
    {
        List<SubjectDisplay> res = subjectMapper.selectAllsubject();
        ListR rrr = new ListR();
        rrr.setList(res);
        return Result.Success(rrr);
    }

    @GetMapping("student")
    Result DisplaySubjectStudent(@RequestParam Integer studentId, @RequestParam String applyStatus)
    {
        System.out.println(studentId);
        System.out.println(applyStatus);
        List<SubjectDisplay> res = subjectMapper.selectAllsubjectByStudent(studentId, applyStatus);
        ListR rrr = new ListR();
        rrr.setList(res);
        return Result.Success(rrr);
    }

    @GetMapping("teacher")
    Result DisplaySubjectTeacher()
    {
        List<SubjectDisplay> res = subjectMapper.selectAllsubjectByTeacher();
        ListR rrr = new ListR();
        rrr.setList(res);
        return Result.Success(rrr);
    }


}
