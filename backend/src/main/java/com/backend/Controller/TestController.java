package com.backend.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081", "http://localhost:8082", "http://127.0.0.1:8082"})
public class TestController {

    @GetMapping("api/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

}
