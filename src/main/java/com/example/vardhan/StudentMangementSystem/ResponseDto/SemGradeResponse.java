package com.example.vardhan.StudentMangementSystem.ResponseDto;

import lombok.Data;

import java.util.List;

@Data
public class SemGradeResponse {
  // private List<String> listOfGrade=List.of("A","A+");
   private String rollNo;
  // private boolean isStudentPass;
   private String duration;
   private int subjects;
}
