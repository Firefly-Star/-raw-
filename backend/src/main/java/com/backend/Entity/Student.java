package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer studentId;
    private String uname;
    private String pword;
    private String studentName;
    private String phoneNumber;
    private String resume;

}
