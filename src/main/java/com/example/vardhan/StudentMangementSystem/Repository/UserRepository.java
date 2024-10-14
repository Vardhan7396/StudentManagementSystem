package com.example.vardhan.StudentMangementSystem.Repository;
import com.example.vardhan.StudentMangementSystem.model.Usermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<Usermodel,Integer> {
    Usermodel findByLoginIdAndPassword(String loginName, String password);
    // Optional<Usermodel> FindByLoginAndPassword(String login,String password);
}
