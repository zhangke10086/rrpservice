package com.rrpserivce.demo.entity;

import io.swagger.models.auth.In;
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
    private Integer count;
    @Column()
    private Integer plan_count;
    @Column()
    private Date time;
    @ManyToOne()
    private Robot robot;

    public Date getTime() {
        return time;
    }

    public double getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

