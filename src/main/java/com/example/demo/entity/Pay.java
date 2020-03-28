package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pay")
@Data
public class Pay {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "payment_amount")
    private int paymentAmount;
    @Column(name = "contract_id")
    private String contractId;
    @Column(name = "payment_time")

    private String paymentTime;
    @Column(name = "payment_deadline")
    private String paymentDeadline;
    @Column(name = "examine_situation")
    private String examineSituation;
    @Column(name = "payment_duration")
    private String paymentDuration;
    @Column(name = "contract_content")
    private String contractContent;
    @Column(name = "connector")
    private String connector;
    @Column(name = "use_time")
    private String useTime;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne
    @JoinColumn(name = "robot_id")
    private Robot robot;
}
