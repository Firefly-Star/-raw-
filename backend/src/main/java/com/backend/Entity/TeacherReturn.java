package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherReturn {

    private Integer teacherId;
    private String teacherName;
    private String remark;
    private String tuname;
    private String tpword;
    private String contactInfo;

}
