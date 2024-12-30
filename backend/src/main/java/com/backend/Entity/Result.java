package com.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private Object data;

    public static Result Success(Object data) {
        return new Result(100, data);
    }
    public static Result Failure(String message) {
        return new Result(101, message);
    }
}