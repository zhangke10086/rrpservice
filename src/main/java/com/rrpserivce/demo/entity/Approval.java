package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "approval")
@Data
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "robot_id")
    private Robot robot;
    @OneToOne
    @JoinColumn(name = "lease_id")
    private Lease lease;
    private String request;
    private Character state;
}
