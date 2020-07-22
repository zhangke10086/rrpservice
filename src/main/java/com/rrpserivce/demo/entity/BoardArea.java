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
    @Column
    private Double plan_area;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

