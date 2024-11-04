package com.backend.Controller;

import com.backend.Entity.*;
import com.backend.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @PostMapping("student")
    Result studentLogin(@RequestBody Student student) {
        Student st = loginMapper.studentLogin(student);
        if (st != null) {
            return Result.Success(null);
        }
        else
        {
            return Result.Failure("密码输入错误");
        }
    }

    @PostMapping("teacher")
    Result teacherLogin(@RequestBody Teacher teacher) {
        Teacher t = loginMapper.teacherLogin(teacher);
        if (t != null) {
            return Result.Success(null);
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
