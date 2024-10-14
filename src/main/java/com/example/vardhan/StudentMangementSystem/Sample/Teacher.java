package com.example.vardhan.StudentMangementSystem.Sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor

@Data
public class Teacher {
    private String teacherName;
    private List<String> mobileNumbers;
   // private String teacherName;

    public Teacher(String teacherName, List<String> mobileNumbers) {
        this.teacherName=teacherName;
        this.mobileNumbers=mobileNumbers;
    }


}
