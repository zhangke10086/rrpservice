package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bench_count")
@Data
public class BenchCount {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private int count;
    @Column()
    private Date time;

}

