package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "warning")
@Data
public class Warning {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private Date time;
    @Column()
    private String location;
//    @Column()
//    private Boolean machine_signal0;
//    @Column()
//    private Boolean machine_signal1;
//    @Column()
//    private Boolean machine_signal2;
//    @Column()
//    private Boolean machine_signal3;
//    @Column()
//    private Boolean machine_signal4;
//    @Column()
//    private Boolean machine_signal5;
//    @Column()
//    private Boolean machine_signal6;
//    @Column()
//    private Boolean machine_signal7;
//    @Column()
//    private Boolean machine_signal8;
//    @Column()
//    private Boolean machine_signal9;
//    @Column()
//    private Boolean machine_signal10;
//    @Column()
//    private Boolean machine_signal11;
//    @Column()
//    private Boolean machine_signal12;
//    @Column()
//    private Boolean machine_signal13;
//    @Column()
//    private Boolean machine_signal14;
//    @Column()
//    private Boolean machine_signal15;
//    @Column()
//    private Boolean machine_signal16;
//    @Column()
//    private Boolean machine_signal17;
//    @Column()
//    private Boolean machine_signal18;
//    @Column()
//    private Boolean machine_signal19;
//    @Column()
//    private Boolean machine_signal20;
//    @Column()
//    private Boolean machine_signal21;
//    @Column()
//    private Boolean machine_signal22;
//    @Column()
//    private Boolean machine_signal23;
//    @Column()
//    private Boolean machine_signal24;
    @ManyToOne()
    private Robot robot;
@ManyToOne()
    private WarnContent num;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

