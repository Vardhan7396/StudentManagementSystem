package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.Repository.StudentsRepository;
import com.example.vardhan.StudentMangementSystem.RequestDTO.AttendanceReqDTO;
import com.example.vardhan.StudentMangementSystem.RequestDTO.StudentsReqDTO;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemGradeResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemMobileResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.StartingLetter;
import com.example.vardhan.StudentMangementSystem.Sample.Student;
import com.example.vardhan.StudentMangementSystem.Service.StudentsService;
import com.example.vardhan.StudentMangementSystem.model.AttendanceModel;
import com.example.vardhan.StudentMangementSystem.model.StudentBio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private StudentsRepository studentsRepository;

    // Endpoint to get students by gender
    @GetMapping("/students")
    public ResponseEntity<List<StudentBio>> getStudentsByGender(@RequestBody StudentsReqDTO  studentsReqDTO) {
        //return studentsRepository.findAllByGender(gender);
        return ResponseEntity.ok(studentsService.getStudentsByGender(studentsReqDTO));
    }
    @GetMapping("/check-student/rollno")
    public ResponseEntity<List<StudentBio>> getStudentsByRollNo(@RequestBody StudentsReqDTO  studentsReqDTO) {

        return ResponseEntity.ok(studentsService.getStudentsByRollNo(studentsReqDTO));
    }
   @GetMapping("/home")
    public String homePage() {
        System.out.println("in homePage..");
        return "home";
    }

    @GetMapping("/student1")
    public String studentPage() {
        System.out.println("in register..");
        return "register";
    }

    @GetMapping("/newhome")
    public String homeNewPage() {
       // System.out.println("in homePage..");
        return "home";
    }

    @GetMapping("/result")
    public String resultPage() {

        return "result";
    }

    @GetMapping("/studentbio")
    public String getResult(@ModelAttribute StudentsReqDTO studentsReqDTO, Model model) {
        StudentBio studentBio =  studentsService.getByRollNo(studentsReqDTO);
        model.addAttribute("studentBio", studentBio);
      /* if(studentBio==null) {
           throw new RuntimeException("no student found");
       }*/
        return "studentbio";
    }



    @PostMapping("create-student")
    public ResponseEntity<StudentBio> studentRegister(@RequestBody StudentsReqDTO studentsReqDTO) {
        StudentBio studentBio = studentsService.registerStudents(studentsReqDTO);

        return ResponseEntity.ok(studentBio);

    }
    @GetMapping("getFrom-data")
    public ResponseEntity <String> getFromData(@RequestBody StudentsReqDTO studentsReqDTO) {
        String duration = studentsService.getFromData(studentsReqDTO);

        return ResponseEntity.ok(duration);

    }
    @GetMapping("getFrom-subjects")
    public ResponseEntity <SemGradeResponse> getFromSubjectData(@RequestBody StudentsReqDTO studentsReqDTO) {
        SemGradeResponse duration = studentsService.getFromSubjectData(studentsReqDTO);


        return ResponseEntity.ok(duration);

    }

    @GetMapping("get-students-phone-number/{number}")
    public ResponseEntity <List<SemMobileResponse>> getStudentPhoneNumber(@PathVariable String number) {
       List<SemMobileResponse> duration = studentsService.getStudentPhoneNumber(number);


        return ResponseEntity.ok(duration);

    }
    @PostMapping("registration")
    public ResponseEntity <StudentBio> registration(@RequestBody StudentsReqDTO studentsReqDTO){
       StudentBio studentBio=studentsService.registration(studentsReqDTO);
       return ResponseEntity.ok(studentBio);
    }


    @GetMapping("/student2")
    public String showRegisterPage(Model model) {
        // This will render register.html from the templates folde
        return "register";
    }
    @GetMapping("/student")
    public String showLoginForm(Model model) {
        model.addAttribute("studentBio", new StudentBio());
        return "register";  // The name of your Thymeleaf template file
    }


    @PostMapping("/save")
    public String registerStudent(@ModelAttribute("studentBio") StudentBio studentBio, Model model) {
        studentsRepository.save(studentBio);

        return "success";  // Redirect to registration page with success message
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // return the name of your login HTML or Thymeleaf template
    }


    @PostMapping("/reCorrections")
    public ResponseEntity<StudentBio> reCorrection(@RequestBody StudentsReqDTO studentsReqDTO){
        StudentBio studentBio=studentsService.reCorrection(studentsReqDTO);
        return ResponseEntity.ok(studentBio);
    }
    @GetMapping("/startingLetter")
    public ResponseEntity<StartingLetter> startingLetter(@RequestBody StudentsReqDTO studentsReqDTO){
        StartingLetter studentBio=studentsService.startingLetter(studentsReqDTO);
        return ResponseEntity.ok(studentBio);
    }
    //map<Character,List<String>>


}











