package com.backend.Controller;

import com.backend.Entity.*;
import com.backend.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/login")
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081", "http://localhost:8082", "http://127.0.0.1:8082"})
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @RequestMapping("student")
    Result studentLogin(@RequestBody Student student) {
        Student st = loginMapper.studentLogin(student);
        System.out.println(st);
        if (st != null) {
            StudentLoginR rrr = new StudentLoginR();
            rrr.setStudentId(st.getStudentId());
            rrr.setMessage("登陆成功");
            return Result.Success(rrr);
        }
        else
        {
            System.out.println("123");
            return Result.Failure("密码输入错误");
        }
    }

    @RequestMapping("teacher")
    Result teacherLogin(@RequestBody Teacher teacher) {
        System.out.println(teacher);
        Teacher t = loginMapper.teacherLogin(teacher);
        if (t != null) {
            TeacherLoginR rrr = new TeacherLoginR();
            rrr.setTeacherId(t.getTeacherId());
            rrr.setMessage("登陆成功");
            return Result.Success(rrr);
        }
        else
        {
            return Result.Failure("密码输入错误");
        }
    }

    @PostMapping("committee")
    Result committeeLogin(@RequestBody Council committee) {
        Council c = loginMapper.councilLogin(committee);
        if (c != null) {
            return Result.Success(null);
        }
        else
        {
            return Result.Failure("密码输入错误");
        }
    }

    @PostMapping("auditor")
    Result auditorLogin(@RequestBody Assessor assessor) {
        Assessor a = loginMapper.assessorLogin(assessor);
        if (a != null) {
            return Result.Success(null);
        }else
        {
            return Result.Failure("密码输入错误");
        }
    }

}
