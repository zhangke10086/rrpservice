package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bench_manage")
@Data
public class BenchManage {
    @Id
    @Column(name = "id")
    private int id;
    @Column(length = 255)
    private String description;
    @OneToOne
    private Bench bench;

}

