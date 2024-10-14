package com.example.vardhan.StudentMangementSystem.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceReqDTO {

    private Integer Id;
    private String studentName;
    private String teacherName;
    private int period;
    private String date;

}
