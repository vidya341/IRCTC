package com.example.IRCTC_SYSTEM.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;
    private String name;
    private LocalDate date;
    private Integer age;
    private String gender;


    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private train Train;
}
