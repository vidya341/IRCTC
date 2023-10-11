package com.example.IRCTC_SYSTEM.transformer;

import com.example.IRCTC_SYSTEM.models.passenger;
import com.example.IRCTC_SYSTEM.models.train;
import com.example.IRCTC_SYSTEM.requestDTO.adding_passDTO;
import lombok.Builder;

import java.time.LocalDate;

public class pass_transformer {
    public static passenger get_pass_obj(adding_passDTO pass_dto)
    {

        passenger pass = passenger.builder().name(pass_dto.getName()).date(pass_dto.getDate()).age(pass_dto.getAge()).gender(pass_dto.getGender()).build();
        return pass;
    }

}
