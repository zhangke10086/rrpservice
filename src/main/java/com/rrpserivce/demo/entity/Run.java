package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}

