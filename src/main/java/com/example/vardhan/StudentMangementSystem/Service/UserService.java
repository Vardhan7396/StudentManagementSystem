package com.example.vardhan.StudentMangementSystem.Service;

import com.example.vardhan.StudentMangementSystem.Repository.UserRepository;
import com.example.vardhan.StudentMangementSystem.RequestDTO.UserModelReqDTO;
import com.example.vardhan.StudentMangementSystem.model.Usermodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Usermodel registerUser(String loginId, String password, String email) {
        Usermodel usermodel = new Usermodel();

        if (loginId != null && password != null) {
            usermodel.setLoginId(loginId);
            usermodel.setPassword(password);
            usermodel.setEmailId(email);
            userRepository.save(usermodel);

        }
        return usermodel;
    }


    public Usermodel registerUser(UserModelReqDTO userModelReqDTO) {
        Usermodel usermodel = new Usermodel();

        if (userModelReqDTO.getLoginName() != null && userModelReqDTO.getEmail() != null) {
            usermodel.setLoginId(userModelReqDTO.getLoginName());
            usermodel.setPassword(userModelReqDTO.getPassword());
            usermodel.setEmailId(userModelReqDTO.getEmail());
            usermodel.setId(userModelReqDTO.getId());
           // usermodel.setCity(userModelReqDTO.getCity());
            userRepository.save(usermodel);

        }
        return usermodel;
    }
    public boolean checkUser(UserModelReqDTO userModelReqDTO) {
        Usermodel usermodelFromDB = userRepository.findByLoginIdAndPassword(userModelReqDTO.getLoginName(), userModelReqDTO.getPassword());
        if (usermodelFromDB == null) return false;
        else return true;


    }
}
