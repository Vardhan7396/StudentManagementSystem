package com.example.vardhan.StudentMangementSystem.Service;

import com.example.vardhan.StudentMangementSystem.Repository.SemRepository;
import com.example.vardhan.StudentMangementSystem.RequestDTO.SemResultReqDTO;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemGradeResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemInternalResponse;
import com.example.vardhan.StudentMangementSystem.ResponseDto.SemResultResponse;
import com.example.vardhan.StudentMangementSystem.model.SemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemService {
    @Autowired
    private SemRepository semRepository;




    public SemModel registerUser(SemResultReqDTO semResultReqDTO) {
        SemModel semModel = new SemModel();

            semModel.setId(semResultReqDTO.getId());
            semModel.setExternal(semResultReqDTO.getExternal());
            semModel.setCredits(semResultReqDTO.getCredits());
            semModel.setInternal(semResultReqDTO.getInternal());
        semModel.setName(semResultReqDTO.getName());
        semModel.setRollNo(semResultReqDTO.getRollNo());
        semModel.setSubjectCode(semResultReqDTO.getSubjectCode());
        semModel.setSubjectName(semResultReqDTO.getSubjectName());
        semModel.setGrade(semResultReqDTO.getGrade());
      //  semModel.s(semResultReqDTO.getSubjectName());
           // usermodel.setCity(userModelReqDTO.getCity());
            semRepository.save(semModel);


        return semModel;
    }
    public List<SemModel> getStudentDetails(SemResultReqDTO semResultReqDTO) {
        return semRepository.findAllByRollNo(semResultReqDTO.getRollNo());

    }

    public SemResultResponse getSemTotalMarks(SemResultReqDTO semResultReqDTO) {

        List<SemModel> totalMarksList = semRepository.findAllByRollNo(semResultReqDTO.getRollNo());
        int totalmarks=0;
        for (SemModel result : totalMarksList) {
            // preparedStatement.setString(1, result.getName());
           // System.out.println(result.getInternal());

            totalmarks=totalmarks+result.getInternal()+result.getExternal();


        }
        //System.out.println(totalmarks);
        double totalPercentage=1200.0;
        SemResultResponse b=new SemResultResponse();
        b.setRollNo(totalMarksList.get(0).getRollNo());
        b.setTotalMarks(totalmarks);
        double k = ((totalmarks) / totalPercentage)*100;
        b.setPercentage(k);


        return b;
    }

    public SemResultResponse getSemResult(SemResultReqDTO semResultReqDTO) {
        SemModel semResultFromDB = semRepository.findAllByRollNoAndSubjectCode(semResultReqDTO.getRollNo(), semResultReqDTO.getSubjectCode());

        return getSemResultResponse(semResultFromDB);

    }

    private SemResultResponse getSemResultResponse(SemModel semResultFromDB) {
        String status = decidePassOrFail(semResultFromDB.getInternal(), semResultFromDB.getExternal());
        SemResultResponse semResultResponse = new SemResultResponse();
        semResultResponse.setRollNo(semResultFromDB.getRollNo());
        semResultResponse.setInternal(semResultFromDB.getInternal());
        semResultResponse.setExternal(semResultFromDB.getExternal());
        semResultResponse.setStatus(status);
        return semResultResponse;
    }

    private String decidePassOrFail(int internal, int external) {
        if (external < 24 || internal + external < 40) return "FAIL";
        return "PASS";
    }

    public List<SemResultResponse> getSemStatus(SemResultReqDTO semResultReqDTO) {
       List<SemModel> semResultFromDB = semRepository.findAllByRollNo(semResultReqDTO.getRollNo());
       List<SemResultResponse> semResultResponseList = new ArrayList<>();
        for (SemModel result : semResultFromDB) {
            SemResultResponse semResultResponse = getSemResultResponse(result);
            semResultResponseList.add(semResultResponse);
        }

        return semResultResponseList;

    }

    public SemResultResponse getRe_correction(SemResultReqDTO semResultReqDTO) {
        SemModel semResultFromDB = semRepository.findAllByRollNoAndSubjectCode(semResultReqDTO.getRollNo(), semResultReqDTO.getSubjectCode());

        semResultFromDB.setInternal(semResultReqDTO.getInternal());
        semResultFromDB.setExternal(semResultReqDTO.getExternal());
        semResultFromDB.setCredits(semResultReqDTO.getCredits());
      // semResultFromDB= semRepository.save(semResultFromDB);
       semRepository.delete(semResultFromDB);


        SemResultResponse semResultResponse = new SemResultResponse();
        semResultResponse.setRollNo(semResultFromDB.getRollNo());
        semResultResponse.setInternal(semResultFromDB.getInternal());
        semResultResponse.setExternal(semResultFromDB.getExternal());
        semResultResponse.setCredits(semResultFromDB.getCredits());
        return semResultResponse;

    }

    public  Integer getMaximumMarks(SemResultReqDTO semResultReqDTO) {
        List<SemModel> totalMarksList = semRepository.findAllBySubjectCode(semResultReqDTO.getSubjectCode());
       // List<Integer> semResultResponseList = new ArrayList<>();
        int b=totalMarksList.get(0).getInternal();
        int c=totalMarksList.get(0).getExternal();
        for (SemModel result : totalMarksList) {
            int a= result.getInternal();
            int d= result.getInternal();
            if(b<a){
                b=a;
            }
            if(c>d){
                c=d;
            }


           // semResultResponseList.add(a);
        }
       /* int b=semResultResponseList.get(0);
        for (Integer result :semResultResponseList ) {
            if(b<result){
                b=result;
            }

        }*/


        return b;



    }

    public SemInternalResponse getInternalExternal(SemResultReqDTO semResultReqDTO) {
        List<SemModel> totalMarksList = semRepository.findAllBySubjectCode(semResultReqDTO.getSubjectCode());
        // List<Integer> semResultResponseList = new ArrayList<>();
        int b=totalMarksList.get(0).getInternal();
        int c=totalMarksList.get(0).getExternal();
        for (SemModel result : totalMarksList) {
            int a= result.getInternal();
            int d= result.getExternal();
            if(b<a){
                b=a;
            }
            if(c>d){
                c=d;
            }


        }
        //semRepository.save()
        SemInternalResponse semInternalResponse = new SemInternalResponse();
      //  semResultResponse.setRollNo(semResultFromDB.getRollNo());
        semInternalResponse.setMaxOfInternals(b);

        semInternalResponse.setMinOfExternals(c);
       // semResultResponse.setCredits(semResultFromDB.getCredits());
        return semInternalResponse;

    }

    public SemGradeResponse getGrade(SemResultReqDTO semResultReqDTO) {
        //  db call
        // get the data


       SemGradeResponse semGradeResponse = new SemGradeResponse();
       //set the response

        return semGradeResponse;
    }


    // return semResultResponse;
}