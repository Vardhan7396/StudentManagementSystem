package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.RequestDTO.AttendanceReqDTO;
import com.example.vardhan.StudentMangementSystem.Service.AttendanceService;
import com.example.vardhan.StudentMangementSystem.model.AttendanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping("attended")
    public ResponseEntity<AttendanceModel> insertAttends(@RequestBody AttendanceReqDTO attendanceReqDTO) {
        AttendanceModel attendanceModel = attendanceService.registerAttends(attendanceReqDTO);
        return ResponseEntity.ok(attendanceModel);

    }





}
