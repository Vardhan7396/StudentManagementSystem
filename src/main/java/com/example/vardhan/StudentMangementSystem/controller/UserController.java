package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.RequestDTO.UserModelReqDTO;
import com.example.vardhan.StudentMangementSystem.Service.UserService;
import com.example.vardhan.StudentMangementSystem.model.Usermodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
   @GetMapping("/homeVardhan")
    public String show(){
        return "homenew";
    }
    @GetMapping("/sudentName")
    public String print(Usermodel usermodel){
        return "register";
    }

    @PostMapping("/student")
    public ResponseEntity<Usermodel> insertUser(@RequestParam("loginId") String loginId,
                                               @RequestParam("emailId") String emailId,
                                               @RequestParam("pswd") String pswd) {
        Usermodel usermodel = userService.registerUser(loginId, pswd, emailId);
        return ResponseEntity.ok(usermodel);

    }

    @PostMapping("register-user-post")
    public ResponseEntity<Usermodel> insertUserByPost(@RequestBody UserModelReqDTO userModelReqDTO) {
        Usermodel usermodel = userService.registerUser(userModelReqDTO);
        return ResponseEntity.ok(usermodel);

    }


}
