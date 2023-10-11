package com.example.IRCTC_SYSTEM.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.service.spi.InjectService;

import java.util.List;

@Entity
@Table(name = "train")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer train_no;
    private String source;
    private String destination;

    @JsonIgnore
    @OneToMany(mappedBy = "Train",cascade = CascadeType.ALL)
    private List<passenger> pass;

}
