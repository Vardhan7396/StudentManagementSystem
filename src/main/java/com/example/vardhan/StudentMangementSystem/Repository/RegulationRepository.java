package com.example.vardhan.StudentMangementSystem.Repository;
import com.example.vardhan.StudentMangementSystem.model.Regulation;
import com.example.vardhan.StudentMangementSystem.model.SemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegulationRepository extends JpaRepository<Regulation,String> {


    Regulation findByRegId(String id);
}
