package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.RequestDTO.SemResultReqDTO;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemGradeResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemInternalResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemResultResponse;
import com.example.vardhan.StudentMangementSystem.Service.SemService;
import com.example.vardhan.StudentMangementSystem.model.SemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class SemController {
    @Autowired
    private SemService semService;
    @PostMapping("sem-marks")
    public ResponseEntity<SemModel> insertMarks(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemModel semModel = semService.registerUser(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
    @GetMapping("get-sem-marks")
    public ResponseEntity<List<SemModel>> getSemMarks(@RequestBody SemResultReqDTO semResultReqDTO) {
        List<SemModel> semModel = semService.getStudentDetails(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
    @GetMapping("get-sem-totalMarks")
    public ResponseEntity<SemResultResponse> getSemTotalMarks(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemResultResponse semModel = semService.getSemTotalMarks(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
    @GetMapping("get-sem-Result")
    public ResponseEntity<SemResultResponse> getSemResult(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemResultResponse semModel = semService.getSemResult(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
    @GetMapping("get-sem-status")
    public ResponseEntity<List<SemResultResponse>> getSemStatus(@RequestBody SemResultReqDTO semResultReqDTO) {
        List<SemResultResponse> semModel = semService.getSemStatus(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
    @GetMapping("get-re_correction")
    public ResponseEntity<SemResultResponse> getRe_correction(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemResultResponse semModel = semService.getRe_correction(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }
   // @GetMapping("get-Maximum_Marks")

    @GetMapping("get-Internal-External")
    public ResponseEntity<SemInternalResponse> getInternalExternal(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemInternalResponse semModel = semService.getInternalExternal(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }

    @GetMapping("dummy")
    public ResponseEntity<SemGradeResponse> getGrade(@RequestBody SemResultReqDTO semResultReqDTO) {
        SemGradeResponse semModel = semService.getGrade(semResultReqDTO);
        return ResponseEntity.ok(semModel);

    }





}
