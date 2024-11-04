package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer teacherId;
    private String teacherName;
    private String uname;
    private String pword;
    private String eduBackground;
    private String institution;
    private Integer age;
    private String major;
    private String phoneNumber;
    private Integer assessorId;

}
