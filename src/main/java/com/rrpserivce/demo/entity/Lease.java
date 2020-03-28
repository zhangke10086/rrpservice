package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lease")
@Data
public class Lease {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "contract_Id")
    private String contractId;
    @Column(name = "cost_way")
    private String costWay;
    @Column(name = "cost_month")
    private String costMonth;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "payment_situation")
    private String paymentSituation;
    @Column(name = "workshop_id")
    private String workshopId;
    @Column(name = "internal_id")
    private String internalId;
    @Column(name = "contract")
    private String contract;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
    @OneToOne
    @JoinColumn(name = "robot_id")
    private Robot robot;
}
