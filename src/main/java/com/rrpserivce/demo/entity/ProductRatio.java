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

    public double getRatio() {
        return ratio;
    }

    public Date getTime() {
        return time;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "ProductRatio{" +
                "id=" + id +
                ", ratio=" + ratio +
                ", time=" + time +
                ", robot=" + robot +
                '}';
    }
}

