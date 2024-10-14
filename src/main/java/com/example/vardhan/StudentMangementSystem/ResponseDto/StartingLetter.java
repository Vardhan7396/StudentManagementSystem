package com.example.vardhan.StudentMangementSystem.ResponseDto;

import com.example.vardhan.StudentMangementSystem.model.StudentBio;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data

public class StartingLetter {
    private int totalCount;
    private int maleCount;
    private int femaleCount;
    private List<StudentBio> studentBioList;
    private Map<Character,List<String>> mobile =new HashMap<>();
}
