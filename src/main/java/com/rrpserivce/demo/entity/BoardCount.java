package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}

