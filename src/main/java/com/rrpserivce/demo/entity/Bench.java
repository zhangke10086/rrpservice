package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}

