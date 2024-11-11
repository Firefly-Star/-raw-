package com.backend.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDisplay {

    private String teacherName;
    private String topicName;
    private String topicType;
    private String description;
    private String applyStatus;

}
