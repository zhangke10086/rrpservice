package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board_area")
@Data
public class BoardArea {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private double area;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;
}

