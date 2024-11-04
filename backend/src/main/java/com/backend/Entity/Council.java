package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Council {

    private Integer councilId;
    private String councilName;
    private String uname;
    private String pword;

}
