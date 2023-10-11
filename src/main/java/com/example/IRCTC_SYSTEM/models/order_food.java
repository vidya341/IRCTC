package com.example.IRCTC_SYSTEM.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class order_food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer food_id;
    private Integer ticket_id;
    private Integer train_id;
    private Integer price;

}
