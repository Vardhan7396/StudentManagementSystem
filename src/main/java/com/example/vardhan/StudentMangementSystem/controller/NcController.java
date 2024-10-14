package com.example.vardhan.StudentMangementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NcController {
    @GetMapping("/nc")
    public String getNc(){
        return "nc";
    }
}
