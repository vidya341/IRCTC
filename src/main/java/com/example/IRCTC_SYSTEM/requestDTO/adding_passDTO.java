package com.example.IRCTC_SYSTEM.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data

public class adding_passDTO {
    private String name;
    private LocalDate date;
    private Integer age;
    private String gender;
    private Integer train_no;
}
