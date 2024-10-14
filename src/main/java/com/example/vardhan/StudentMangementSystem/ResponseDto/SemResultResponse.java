package com.example.vardhan.StudentMangementSystem.ResponseDto;

import lombok.Data;

@Data
public class SemResultResponse {
    private int totalMarks;
    private String rollNo;
    private double percentage;
    private int internal;
    private int external;
    private String status;
    private int credits;
}
