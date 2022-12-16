package com.mohammedismaiel.social_cv.app.resource;

import com.mohammedismaiel.social_cv.app.exception.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test extends ExceptionHandling {
    @GetMapping("/test")
    public ResponseEntity<String> sayHello() {
        System.out.println("accessing hello");
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}
