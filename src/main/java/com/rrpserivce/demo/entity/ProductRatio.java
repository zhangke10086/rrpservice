package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_ratio")
@Data
public class ProductRatio {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private double ratio;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;
}

