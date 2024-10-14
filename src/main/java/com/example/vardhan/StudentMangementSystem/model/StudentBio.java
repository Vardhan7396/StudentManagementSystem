package com.example.vardhan.StudentMangementSystem.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="studentbio")
@Data
public class StudentBio {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLL_NO")
    private String rollNumber;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="GENDER")
    private String gender;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="MOBILE_NUMBER")
    private String mobileNo;
    @Column(name="EMAIL_ID")
    private String email;
    @Column(name="MIDDLE_NAME")
    private String middleName;
    @Column(name="DATE_OF_BIRTH")
    private String dob;
    @Column(name="COLLEGE")
    private String college;
    @Column(name="DEGREE")
    private String degree;
    @Column(name="YEAR_OF_PASSING")
    private int yearOfPassing;
    @Column(name="PAN_NUMBER")
    private String panNumber;
    @Column(name="REGULATION")
    private String regulation;




    // Constructors, getters, setters
}

