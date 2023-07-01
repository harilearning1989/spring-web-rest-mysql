package com.web.demo.controls;

import com.web.demo.aop.Audit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRestController {

    @Audit("Executing method 1")
    @RequestMapping("hello")
    public String helloWorld(){
        return "Hello";
    }

    
}
