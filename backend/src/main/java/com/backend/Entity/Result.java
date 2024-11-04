package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String status;
    private Object data;

    public static Result Success(Object data) {
        return new Result("success", data);
    }
    public static Result Failure(String message) {
        return new Result("failure", message);
    }
}