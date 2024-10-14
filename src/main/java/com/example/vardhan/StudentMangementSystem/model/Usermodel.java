package com.example.vardhan.StudentMangementSystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="vardhan")
@Data
public class Usermodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String string;
    private String loginId;
    private String password;
    private String emailId;

}
