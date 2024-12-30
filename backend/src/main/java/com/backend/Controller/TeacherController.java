package com.backend.Controller;

import com.backend.Entity.Apply;
import com.backend.Entity.Result;
import com.backend.Entity.TR;
import com.backend.Entity.TeacherReturn;
import com.backend.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081", "http://localhost:8082", "http://127.0.0.1:8082"})
public class TeacherController {

    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping("api/teachers/display")
    Result displayTeachers(){
        List<TeacherReturn> res = teacherMapper.selectAll();
        TR tr = new TR();
        tr.setList(res);
        return Result.Success(tr);
    }

    @GetMapping("api/teachers/info")
    Result getTeacherInfo(@RequestParam Integer topicId){
        TeacherReturn res = teacherMapper.selectById(topicId);
        return Result.Success(res);
    }

    @PostMapping("api/apply")
    Result apply(@RequestBody Apply apply)
    {
        teacherMapper.insert(apply.getTopicId(), apply.getStudentId());
        return Result.Success(null);
    }

}
