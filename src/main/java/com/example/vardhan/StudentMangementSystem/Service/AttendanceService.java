package com.example.vardhan.StudentMangementSystem.Service;

import com.example.vardhan.StudentMangementSystem.Repository.AttendanceRepository;
import com.example.vardhan.StudentMangementSystem.RequestDTO.AttendanceReqDTO;
import com.example.vardhan.StudentMangementSystem.model.AttendanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;




    public AttendanceModel registerAttends(AttendanceReqDTO attendanceReqDTO) {
        AttendanceModel attendanceModel = new AttendanceModel();

            attendanceModel.setId(attendanceReqDTO.getId());
            attendanceModel.setStudentName(attendanceReqDTO.getStudentName());
            attendanceModel.setPeriod(attendanceReqDTO.getPeriod());
            attendanceModel.setDate(attendanceReqDTO.getDate());
             attendanceModel.setTeacherName(attendanceReqDTO.getTeacherName());
       // attendenceModel.setAttendstudent(attendenceReqDTO.getAttendstudent());
       /* attendenceModel.setSubjectCode(attendenceReqDTO.ge());
        attendenceModel.setSubjectName(attendenceReqDTO.getSubjectName());
        attendenceModel.setGrade(attendenceReqDTO.getGrade());*/
      //  semModel.s(semResultReqDTO.getSubjectName());
           // usermodel.setCity(userModelReqDTO.getCity());
            attendanceRepository.save(attendanceModel);


        return attendanceModel;
    }

}