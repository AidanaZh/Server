package com.example.newTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coach_id;
    private String coach_kod;
    private String coach_name;
    private String coach_surname;
    @OneToOne
    @JoinColumn
    private User_info user_info;
}
