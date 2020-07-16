package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "payment_time")
    private String paymentTime;
    @Column(name = "payment_deadline")
    private String paymentDeadline;
    @Column(name = "examine_situation")
    private String examineSituation;
    @Column(name = "payment_duration")
    private String paymentDuration;
    @Column(name = "payment_voucher")
    private String paymentVoucher ;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne
    @JoinColumn(name = "robot_id")
    private Robot robot;
    @OneToOne
    @JoinColumn(name = "lease_id")
    private Lease lease;
    @Column(name = "uploadurl")
    private String uploadurl ;
}
