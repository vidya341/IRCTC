package com.example.IRCTC_SYSTEM.repository;

import com.example.IRCTC_SYSTEM.models.passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface pass_repo extends JpaRepository<passenger,Integer> {
    //List<passenger> findpassengersBydate(LocalDate date);



}
