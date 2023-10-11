package com.example.IRCTC_SYSTEM.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data

public class total_price_fooddto {
    private LocalDate date;
    private int train_no;
}
