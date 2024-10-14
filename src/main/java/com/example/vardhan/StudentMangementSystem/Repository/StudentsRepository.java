package com.example.vardhan.StudentMangementSystem.Repository;
import com.example.vardhan.StudentMangementSystem.model.StudentBio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<StudentBio, String> {


 /* List<Studentbio> findAllByGender(String gender);
  @Query("SELECT s from Studentbio s where s.gender= :gender and s.name = :name")
  List<Studentbio> getAllStudentBySearch(@Param("gender")  String gender,@Param("name")  String name);
 */
 List<StudentBio> findAllByGenderAndFirstName(String gender, String firstName);

 List<StudentBio> findAllByRollNumber(String rollNumber);

 StudentBio findByRollNumberOrEmail(String rollNumber, String email);

 // List<Studentbio> findAllByMOBILENUMBEROrEMAILID(String mobileNumber,String email);

 List<StudentBio> findAllByMobileNoOrEmail(String mobileNo, String email);

 Optional<StudentBio> findByEmail(String email);

 Optional<StudentBio> findByEmailOrMobileNo(String email, String mobileNo);

 Optional<StudentBio> findByEmailOrMobileNoOrPanNumber(String email, String mobileNo, String panNumber);

 // void findAByRollNumber(String rollNo);

 StudentBio findByRollNumber(String rollNo);

 List<StudentBio> findByMobileNoStartingWith(String number);

 List<StudentBio> findByMobileNoEndingWith(String suffix);

 //List<StudentBio> findAllByStartingWith(String firstName);

 List<StudentBio> findAllByFirstNameStartingWith(String firstName);
    /*@Query("SELECT s FROM Studentbio s WHERE s.mobileNo LIKE %:mobileNo% OR s.email LIKE %:email%")
    List<Studentbio> findAllByMobileNoLikeOrEmailLikeq(@Param("mobileNo") String mobileNo, @Param("email") String email);
*/
}






