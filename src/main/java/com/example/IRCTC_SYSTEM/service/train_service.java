package com.example.IRCTC_SYSTEM.service;

import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.repository.train_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class train_service {
    @Autowired
    private train_repo trainrepo;
    public String add_train(train tr)throws Exception
    {
        if(tr.getTrain_no()!=null)
        {
            throw new Exception("do not provide id");
        }
        trainrepo.save(tr);
        return "train saved succesfully";
    }
}
