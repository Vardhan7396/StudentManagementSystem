package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.Sample.Address;
import com.example.vardhan.StudentMangementSystem.Sample.ENUMS.DEGREE;
import com.example.vardhan.StudentMangementSystem.Sample.School;
import com.example.vardhan.StudentMangementSystem.Sample.Student;
import com.example.vardhan.StudentMangementSystem.Sample.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //wpa for to initialize list of student
        List<Student> students=new ArrayList<>();
        for(int i=0;i<3;i++){
            Student student=new Student();
            student.setId(i);
            student.setName("s"+i);
            students.add(student);
        }
       /* List<Student> advanced = List.of(new Student("s1",1,null),
                new Student("s2",2),
                new Student("s3",3));
        System.out.println(students);
        System.out.println(advanced);*/
        List<String> s =new ArrayList<>();
        s.add("A");
        s.add("B");
        s.add("C");
       // System.out.println(s);
        Student student=new Student();
        student.setName("vardhan");
        student.setId(2);
        Address address=new Address();
        address.setLineName("12-14");
        address.setCity("vinukonda");
        address.setState("ap");
        student.setHomeAddress(address);

        Address offcAddr=new Address();
        offcAddr.setLineName("12-15");
        offcAddr.setCity("guntur");
        offcAddr.setState("ap");
        student.setOfficeAddress(offcAddr);

        List<DEGREE> degreeItems=List.of(DEGREE.SSC,DEGREE.INTER,DEGREE.B_TECH,DEGREE.M_TECH);
        student.setDegrees(degreeItems);
        student.setHighestDegree(DEGREE.M_TECH);
        student.setPassed(true);
       // System.out.println(degreeItems);
        School school=new School();
        school.setSchoolName("harsha");
        List<Teacher> teacher=new ArrayList<>();
        Teacher name=new Teacher() ;
        name.setTeacherName("vani");

        List<String> mobileNo=new ArrayList<>();
        mobileNo.add("1222232");
        mobileNo.add("987653");

        name.setMobileNumbers(mobileNo);
        teacher.add(name);
        Teacher name1=new Teacher() ;
        name1.setTeacherName("saraswathi");

        List<String> mobileNo1=new ArrayList<>();
        mobileNo1.add("1227562");
        mobileNo1.add("9879953");

        List<Teacher> tmpList = List.of(new Teacher("tc1",List.of("88","89")),
                new Teacher("tc2",List.of("888","899")),
                new Teacher("tc3",List.of("88888","89888")), new Teacher("tc4",List.of("88811","89922")));




        name1.setMobileNumbers(mobileNo1);
        teacher.add(name1);
        school.setTeachers(teacher);
        student.setSchool(school);






        System.out.println(student);
       // System.out.println(address);





    }



}
