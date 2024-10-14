package com.example.vardhan.StudentMangementSystem.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModelReqDTO {

    private Integer id;
    private String loginName;
    private String password;
    private String email;
    private String city;
}
