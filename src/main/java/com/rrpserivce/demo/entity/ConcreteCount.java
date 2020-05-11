package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "concrete_count")
@Data
public class ConcreteCount {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private double count;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;
}

