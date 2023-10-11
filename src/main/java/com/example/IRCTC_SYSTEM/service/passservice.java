package com.example.IRCTC_SYSTEM.service;

import com.example.IRCTC_SYSTEM.models.passenger;
import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.repository.pass_repo;
import com.example.IRCTC_SYSTEM.repository.train_repo;
import com.example.IRCTC_SYSTEM.requestDTO.adding_passDTO;
import com.example.IRCTC_SYSTEM.requestDTO.pass_bet_xy;
import com.example.IRCTC_SYSTEM.requestDTO.pass_x_y_d;
import com.example.IRCTC_SYSTEM.transformer.pass_transformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data

@Service
public class passservice {
    @Autowired
    private pass_repo passRepo;
    @Autowired
    private train_repo trainrepo;

    public String add_pass(adding_passDTO pass)throws Exception
    {
        train train_obj  = trainrepo.findById(pass.getTrain_no()).get();
        passenger pass_obj = pass_transformer.get_pass_obj(pass);
        pass_obj.setTrain(train_obj);
        train_obj.getPass().add(pass_obj);
        trainrepo.save(train_obj);
        return "passenger saved succesfully";
    }
    public List<passenger> get_pass_xyd(pass_x_y_d passdto)throws Exception
    {

        List<train> trains = trainrepo.findtrainsBysourceAnddestination(passdto.getSource(),passdto.getDest());
        List<passenger> res_pass = new ArrayList<>();
        for(train t:trains)
        {
            System.out.println(t);
            List<passenger> temp_pass = t.getPass();
            for(passenger p:temp_pass)
            {
                if(p.getDate().isEqual(passdto.getDate()))
                {
                    res_pass.add(p);
                }
            }
        }
        return res_pass;
    }
    public List<passenger> get_between_xy(pass_bet_xy pass_bet_dto)
    {
        List<train> train_list = trainrepo.findtrainsBydest(pass_bet_dto.getDest());
        List<passenger> res = new ArrayList<>();
        for(train t:train_list)
        {
            List<passenger> pass = t.getPass();
            for(passenger p:pass)
            {
                if(p.getAge()>=pass_bet_dto.getX() && p.getAge()<=pass_bet_dto.getY())
                {
                    res.add(p);
                }
            }
        }
        return res;
    }
}
