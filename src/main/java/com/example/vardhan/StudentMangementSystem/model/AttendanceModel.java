package com.example.vardhan.StudentMangementSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="attendance")
@Data
public class AttendanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String studentName;
    private String teacherName;
    private int period;
    private String date;
    //private String attendstudent;


}
