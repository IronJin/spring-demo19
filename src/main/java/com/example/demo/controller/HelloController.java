package com.example.demo.controller;

import com.example.demo.service.Hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    private String msgTemplate = "%s님 반갑습니다.";

    //URL 에 파라미터 넘겨 정보 받기
    @GetMapping("/hello")
    private Hello getHelloMsg(@RequestParam(value = "name") String name) {
        return new Hello(String.format(msgTemplate, name));
    }


}
