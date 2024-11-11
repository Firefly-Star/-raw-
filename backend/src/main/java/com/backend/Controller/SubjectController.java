package com.backend.Controller;

import com.backend.Entity.Result;
import com.backend.Entity.Subject;
import com.backend.Entity.SubjectDisplay;
import com.backend.Entity.SubjectId;
import com.backend.Mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topic")
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
        return Result.Success(res);
    }


}
