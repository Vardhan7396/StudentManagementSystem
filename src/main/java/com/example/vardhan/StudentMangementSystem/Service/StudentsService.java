package com.example.vardhan.StudentMangementSystem.Service;

import com.example.vardhan.StudentMangementSystem.Repository.RegulationRepository;
import com.example.vardhan.StudentMangementSystem.Repository.StudentsRepository;
import com.example.vardhan.StudentMangementSystem.RequestDTO.StudentsReqDTO;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemGradeResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemMobileResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.StartingLetter;
import com.example.vardhan.StudentMangementSystem.model.Regulation;
import com.example.vardhan.StudentMangementSystem.model.StudentBio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private RegulationRepository regulationRepository;

    public List<StudentBio> getStudentsByGender(StudentsReqDTO studentsReqDTO) {
        return studentsRepository.findAllByGenderAndFirstName(studentsReqDTO.getGender(), studentsReqDTO.getFirstName());
    }

    public List<StudentBio> getStudentsByRollNo(StudentsReqDTO studentsReqDTO) {
        return studentsRepository.findAllByRollNumber(studentsReqDTO.getRollNo());
    }

    public List<StudentBio> showMobileNumber(StudentsReqDTO studentsReqDTO) {
        return studentsRepository.findAllByMobileNoOrEmail(studentsReqDTO.getMobileNo(), studentsReqDTO.getEmail());
    }

    public StudentBio getByRollNo(StudentsReqDTO studentsReqDTO) {
        return studentsRepository.findByRollNumberOrEmail(studentsReqDTO.getSearchParam(), studentsReqDTO.getSearchParam());
    }


    public StudentBio registerStudents(StudentsReqDTO studentsReqDTO) {
        Optional<StudentBio> byId = studentsRepository.findByEmailOrMobileNoOrPanNumber(studentsReqDTO.getEmail(), studentsReqDTO.getMobileNo(), studentsReqDTO.getPanNumber());
        if (byId.isPresent()) {
            System.out.println("Already email is present .. so not saving..");
            return null;
        }
        //  StudentBio studentBio1 = byId.get();

        StudentBio studentBio = new StudentBio();
        studentBio.setEmail(studentsReqDTO.getEmail());
        studentBio.setGender(studentsReqDTO.getGender());
        studentBio.setRollNumber(studentsReqDTO.getRollNo());
        studentBio.setMobileNo(studentsReqDTO.getMobileNo());
        studentBio.setPanNumber(studentsReqDTO.getPanNumber());


        /*attendanceModel.setPeriod(attendanceReqDTO.getPeriod());
        attendanceModel.setDate(attendanceReqDTO.getDate());
        attendanceModel.setTeacherName(attendanceReqDTO.getTeacherName());*/
        return studentsRepository.save(studentBio);
    }

    public String getFromData(StudentsReqDTO studentsReqDTO) {
        //  SELECT * FROM studentbio where ROLL_No = '21NE1A0202'
        StudentBio FromDb = studentsRepository.findByRollNumber(studentsReqDTO.getRollNo());
        String regulationId = FromDb.getRegulation();
        //   SELECT * FROM regulation where id = 'R20';
        Regulation regulation1 = regulationRepository.findByRegId(regulationId);
        String duration1 = regulation1.getDuration();
        return duration1;


    }

    public SemGradeResponse getFromSubjectData(StudentsReqDTO studentsReqDTO) {
        StudentBio fromDb = studentsRepository.findByRollNumber(studentsReqDTO.getRollNo());

        Regulation regulation1 = regulationRepository.findByRegId(fromDb.getRegulation());

        regulation1.setSubjects(studentsReqDTO.getSubjects());
        regulationRepository.save(regulation1);

        SemGradeResponse semGradeResponse = new SemGradeResponse();
        semGradeResponse.setDuration(regulation1.getDuration());
        semGradeResponse.setSubjects(regulation1.getSubjects());
        semGradeResponse.setRollNo(fromDb.getRollNumber());
        return semGradeResponse;
    }

    public List<SemMobileResponse> getStudentPhoneNumber(String number) {
        List<StudentBio> byMobileNoStartingWith = studentsRepository.findByMobileNoStartingWith(number);
        List<SemMobileResponse> mobileList=new ArrayList<>();

        for(StudentBio mobile:byMobileNoStartingWith){
            SemMobileResponse semMobileResponse=new SemMobileResponse();
            if(mobile.getGender().equals("MALE") && mobile.getLastName().startsWith("S")) {
               // mobileList.add(mobile.getMobileNo());
              //  mobileList.add(mobile.getFirstName());
                semMobileResponse.setMobileNumber(mobile.getMobileNo());
                semMobileResponse.setName(mobile.getFirstName());
                mobileList.add(semMobileResponse);

            }
        }

        return mobileList;
    }

    public StudentBio registration(StudentsReqDTO studentsReqDTO) {
        List<StudentBio> byId=studentsRepository.findAllByRollNumber(studentsReqDTO.getRollNo());
        if (byId.isEmpty()) {
            StudentBio studentBio = new StudentBio();
            studentBio.setRollNumber(studentsReqDTO.getRollNo());
            studentBio.setEmail(studentsReqDTO.getEmail());
            return studentsRepository.save(studentBio);
        }
        else{
            return null;
        }

    }

    public StudentBio reCorrection(StudentsReqDTO studentsReqDTO) {
        List<StudentBio> fromDb=  studentsRepository.findAllByRollNumber(studentsReqDTO.getRollNo());
        if(fromDb.isEmpty()){
            return null;
        }else{
            StudentBio studentBio=new StudentBio();
            studentBio.setRollNumber(studentsReqDTO.getRollNo());
            studentBio.setEmail(studentsReqDTO.getEmail());
            return studentsRepository.save(studentBio);
        }
    }

    public StartingLetter startingLetter(StudentsReqDTO studentsReqDTO) {
      //  List<Studen          tBio>fromDb=studentsRepository.findAllByFirstNameStartingWith(studentsReqDTO.getFirstName());
        List<StudentBio>fromDb=studentsRepository.findAll();



        StartingLetter startingLetter=new StartingLetter();
        List<String> mb =new ArrayList<>();
         Map<Character,List<String>> mobile =new HashMap<>();
         Map<Character,List<String>> mobileCnt =new HashMap<>();

        for(StudentBio i:fromDb) {
            char c = i.getFirstName().charAt(0);
            if (mobileCnt.containsKey(c)) {
                List<String> m1 = mobileCnt.get(c);
                m1.add(i.getMobileNo());
                mobileCnt.put(c, m1);
            } else {
                mobileCnt.put(c, new ArrayList<>(List.of(i.getMobileNo())));

            }

        }
        System.out.println(mobileCnt);
       // System.out.println(mobile.get('A').size());
        startingLetter.setMobile(mobileCnt);

        return startingLetter;




      /*  startingLetter.setTotalCount(fromDb.size());
        startingLetter.setStudentBioList(fromDb);
        int male=0;
        int female=0;
        long m= fromDb.stream()
                .filter(i -> i.getGender().equals("MALE")).count();
        for(StudentBio i:fromDb){
            if(i.getGender().equals("MALE")){
                male=male+1;
            }
            else{
                female=female+1;
            }

        }
        startingLetter.setMaleCount(male);
        startingLetter.setFemaleCount(female);
        return startingLetter;

        //return fromDb;*/
    }


}