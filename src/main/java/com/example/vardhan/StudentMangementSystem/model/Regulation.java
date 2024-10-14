package com.example.vardhan.StudentMangementSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="REGULATION")
@Data
public class Regulation {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String regId;
    @Column(name = "duration")
    private String duration;
    @Column(name = "subjects")
    private int subjects;
   // @Column(name = "SUBJECT_CODE")


}
