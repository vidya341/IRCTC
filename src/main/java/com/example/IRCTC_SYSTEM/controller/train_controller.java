package com.example.IRCTC_SYSTEM.controller;

import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.service.train_service;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j

@RequestMapping("/train")

public class train_controller {
    @Autowired
    private train_service trainser;
    @PostMapping("/add_train")
    public ResponseEntity add_train(@RequestBody train tr)
    {
        try{
            System.out.println(tr.getSource());
            String ans = trainser.add_train(tr);
            return new ResponseEntity(ans, HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
