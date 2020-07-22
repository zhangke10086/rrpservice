package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
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
    private Integer plan_count;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;

    public int getCount() {
        return count;
    }

    public Date getTime() {
        return time;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

