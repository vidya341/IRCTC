package com.example.IRCTC_SYSTEM.controller;

import com.example.IRCTC_SYSTEM.models.passenger;
import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.requestDTO.pass_bet_xy;
import com.example.IRCTC_SYSTEM.requestDTO.pass_x_y_d;
import com.example.IRCTC_SYSTEM.service.passservice;
import com.example.IRCTC_SYSTEM.service.train_service;
import com.example.IRCTC_SYSTEM.requestDTO.adding_passDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/passenger")
@Slf4j

public class passenger_controller {
    @Autowired
    private passservice pass_ser;
    @PostMapping("/add_pass")
    public ResponseEntity add_train(@RequestBody adding_passDTO pass)
    {
        try{
            String ans = pass_ser.add_pass(pass);
            return new ResponseEntity(ans, HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_fromxtoy_ondate")
    public ResponseEntity get_passengers(@RequestBody pass_x_y_d passdto)
    {
        try {
            List<passenger> ans = pass_ser.get_pass_xyd(passdto);
            return new ResponseEntity(ans,HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_between_xyd")
    public ResponseEntity get_between_age_dest(@RequestBody pass_bet_xy pass_betdto)
    {
        try {
            List<passenger> ans = pass_ser.get_between_xy(pass_betdto);
            if(ans.isEmpty())
            {
                return new ResponseEntity("no passengers found",HttpStatus.OK);
            }
            return new ResponseEntity(ans,HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }
}
