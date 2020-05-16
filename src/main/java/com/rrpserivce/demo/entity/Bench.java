package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bench")
@Data
public class Bench {
    @Id
    @Column(name = "id")
    private int id;
    @Column(length = 12)
    private String number;
    @Column()
    private String description;
    @Column(length = 12)
    private String workshop;
    @ManyToOne()
    private Robot robot;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

