package com.example.vardhan.StudentMangementSystem.Repository;
import com.example.vardhan.StudentMangementSystem.model.SemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemRepository extends JpaRepository<SemModel,Integer> {
   // Usermodel findByLoginIdAndPassword(String loginName, String password);
    // Optional<Usermodel> FindByLoginAndPassword(String login,String password);
    //select * from sem_results where ROLL_NO=12345;
    List<SemModel> findAllByRollNo(String rollNo);

    SemModel findAllByRollNoAndSubjectCode(String rollNo,String subjectCode);

    List<SemModel> findAllBySubjectCode(String rollNo);
}
