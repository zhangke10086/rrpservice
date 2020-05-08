package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "remind")
@Data
public class Remind {
    @Id
    @Column(name = "id")
    private int id;
    @OneToOne()
    @JoinColumn(name = "robot_id")
    private Robot robot;
    @OneToOne()
    @JoinColumn(name = "company_id")
    private Company company;
}

