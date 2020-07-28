package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "run")
@Data
public class Run {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private double open;
    @Column()
    private double run;
    @Column()
    private double wait;
    @Column()
    private double warn;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

