package com.example.IRCTC_SYSTEM.controller;

import com.example.IRCTC_SYSTEM.models.order_food;
import com.example.IRCTC_SYSTEM.requestDTO.total_price_fooddto;
import com.example.IRCTC_SYSTEM.service.food_service;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@Slf4j

public class food_controller {
    @Autowired
    private food_service foodser;

    @PostMapping("/add_food")

    public ResponseEntity add_food(@RequestBody order_food food)
    {
        try{
            String ans = foodser.add_food(food);
            return new ResponseEntity(ans,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_total_price")
    public ResponseEntity get_total_price(@RequestBody total_price_fooddto fooddto)
    {
        try {
            int ans = foodser.get_price(fooddto);
            return new ResponseEntity(ans,HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
