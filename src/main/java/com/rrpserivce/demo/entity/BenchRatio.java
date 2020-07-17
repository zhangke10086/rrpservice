package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bench_ratio")
@Data
public class BenchRatio {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private double ratio;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;

    public Date getTime() {
        return time;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}

