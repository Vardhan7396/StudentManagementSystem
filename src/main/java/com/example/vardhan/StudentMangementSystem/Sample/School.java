package com.example.vardhan.StudentMangementSystem.Sample;

import com.example.vardhan.StudentMangementSystem.Sample.ENUMS.DEGREE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private String schoolName;
    private List<Teacher> teachers;

}
