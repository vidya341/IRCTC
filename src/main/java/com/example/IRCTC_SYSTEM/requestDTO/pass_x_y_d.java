package com.example.IRCTC_SYSTEM.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data

public class pass_x_y_d {
    private String source;
    private String dest;
    private LocalDate date;

}
