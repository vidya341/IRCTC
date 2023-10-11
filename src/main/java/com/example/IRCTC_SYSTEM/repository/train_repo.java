package com.example.IRCTC_SYSTEM.repository;

import com.example.IRCTC_SYSTEM.models.passenger;
import com.example.IRCTC_SYSTEM.models.train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface train_repo extends JpaRepository<train,Integer> {
    @Query(value = "select * from train where source=:sour and destination=:dest",nativeQuery = true)
    List<train> findtrainsBysourceAnddestination(String sour, String dest);

    @Query(value = "select * from train where destination=:dest",nativeQuery = true)
    List<train> findtrainsBydest(String dest);

}
