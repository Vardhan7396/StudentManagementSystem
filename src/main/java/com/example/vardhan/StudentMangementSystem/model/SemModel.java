package com.example.vardhan.StudentMangementSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="sem_results")
@Data
public class SemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROLL_NO")
    private String rollNo;
    @Column(name = "SUBJECT_CODE")
    private String subjectCode;
    @Column(name = "SUBJECT_NAME")
    private String subjectName;
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "INTERNAL")
    private int internal;
    @Column(name = "EXTERNAL")
    private int external;
    @Column(name = "CREDITS")
    private int credits;

}
