package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bench_data")
@Data
public class BenchData {
    @Id
    @Column(name = "id")
    private int id;
    @Column(length = 255)
    private String number;
    @Column
    private Date time;
    @ManyToOne()
    private Bench bench;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private Character state;
}

