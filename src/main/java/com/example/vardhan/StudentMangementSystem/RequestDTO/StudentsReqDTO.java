package com.example.vardhan.StudentMangementSystem.RequestDTO;

import com.example.vardhan.StudentMangementSystem.Sample.ENUMS.GENDER;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsReqDTO {

    private Integer id;
    private String gender;
    private String firstName;
    private String email;
    private String city;
    private String rollNo;
    private String mobileNo;
    private String searchParam;
    private String panNumber;
    private int subjects;
    private GENDER genderEnum;
    private String rollNumber;
   // private  String



}
