package com.example.vardhan.StudentMangementSystem.Sample;

import com.example.vardhan.StudentMangementSystem.Sample.ENUMS.DEGREE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int id;
    private Address homeAddress;
    private Address officeAddress;
    private List <DEGREE> degrees;
    private DEGREE highestDegree ;
    private boolean isPassed ;
    private School school;

}
