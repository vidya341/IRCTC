package com.example.IRCTC_SYSTEM.repository;

import com.example.IRCTC_SYSTEM.models.order_food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface food_repository extends JpaRepository<order_food,Integer> {

    @Query(value = "select * from food where ticket_id=:id",nativeQuery = true)
    order_food findByticket_id(int id);

    @Query(value = "select * from food where train_id=:no",nativeQuery = true)
    List<order_food> findfoodsBytrain_no(int no);
}
