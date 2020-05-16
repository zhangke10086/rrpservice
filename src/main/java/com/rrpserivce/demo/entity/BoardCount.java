package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board_count")
@Data
public class BoardCount {
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

