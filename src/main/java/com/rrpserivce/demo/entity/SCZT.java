package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sczt")
@Data
public class SCZT {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "mtjr")
    private String mtjr;
    @Column(name = "smsb")
    private String smsb;
    @Column(name = "znbl")
    private String znbl;
    @Column(name = "zdms")
    private String zdms;
    @Column(name = "ntsc")
    private String ntsc;
    @Column(name = "dcxz")
    private String dcxz;
    @Column(name = "xcxz")
    private String xcxz;
    @Column(name = "zdpt")
    private String zdpt;
    @Column(name = "znbl1")
    private String znbl1;
    @OneToOne
    @JoinColumn(name = "robot_id",referencedColumnName = "id")
    private Robot robot;

}
