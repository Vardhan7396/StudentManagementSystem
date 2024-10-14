package com.example.vardhan.StudentMangementSystem.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemResultReqDTO {

    private Integer Id;
    private String name;
    private String rollNo;
    private String subjectCode;
    private String subjectName;
    private String grade;
    private int internal;
    private int external;
    private int credits;

}
