package com.example.IRCTC_SYSTEM.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.IRCTC_SYSTEM.models.order_food;
import com.example.IRCTC_SYSTEM.models.passenger;
import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.repository.food_repository;
import com.example.IRCTC_SYSTEM.repository.pass_repo;
import com.example.IRCTC_SYSTEM.repository.train_repo;
import com.example.IRCTC_SYSTEM.requestDTO.total_price_fooddto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class food_service {

    @Autowired
    private food_repository food_repo;
    @Autowired
    private train_repo trainrepo;
    @Autowired
    private pass_repo passrepo;


    public String add_food(order_food food)throws Exception
    {
        if(food.getFood_id()!=null)
        {
            throw new Exception("do not provide id");
        }
        food_repo.save(food);
        return "food saved";
    }
    public int get_price(total_price_fooddto fooddto)throws Exception
    {
//        Optional<train> train_op = trainrepo.findById(fooddto.getTrain_no());
//        if(train_op==null)
//        {
//            throw new Exception("no train found");
//        }
//        train train_obj = train_op.get();
//        List<passenger> pass = train_obj.getPass();
//        int total=0;
//        for(passenger p:pass)
//        {
//            if(p.getDate().isEqual(fooddto.getDate()))
//            {
//                int t_id = p.getTicket_id();
//                order_food food = food_repo.findByticket_id(t_id);
//                total+=food.getPrice();
//            }
//        }
//        return total;
        List<order_food> food_list = food_repo.findfoodsBytrain_no(fooddto.getTrain_no());
        int total=0;
        for(order_food f:food_list)
        {
            int tic_id = f.getTicket_id();
            passenger p = passrepo.findById(tic_id).get();
            if(p.getDate().isEqual(fooddto.getDate()))
            {
                total+=f.getPrice();
            }
        }
        return total;
    }
}
