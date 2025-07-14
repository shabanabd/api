package com.demo.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
@RequiredArgsConstructor
@Validated
@Slf4j
public class InfoController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        log.info("welcome endpoint");

        return new ResponseEntity<>("Welcome to new API.", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<String> getInfo(){
        log.info("get info endpoint");

        return new ResponseEntity<>("API V1", HttpStatus.OK);
    }
}
