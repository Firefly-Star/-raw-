package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReturn {

    private Integer studentId;
    private String studentName;
    private String suname;
    private String spword;
    private String contactInfo;
    private String resume;


}
