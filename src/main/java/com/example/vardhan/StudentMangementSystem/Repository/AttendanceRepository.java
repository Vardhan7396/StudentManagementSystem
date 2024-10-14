package com.example.vardhan.StudentMangementSystem.Repository;
import com.example.vardhan.StudentMangementSystem.model.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AttendanceRepository extends JpaRepository<AttendanceModel,Integer> {
   // static void save(AttendenceModel attendenceModel) {
   //}
    // Usermodel findByLoginIdAndPassword(String loginName, String password);
    // Optional<Usermodel> FindByLoginAndPassword(String login,String password);
}
