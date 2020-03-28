package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Company")
@Data
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "legal_person")
    private String legalPerson;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @OneToOne
    @JoinColumn(name = "type",referencedColumnName = "type")
    private CompanyType companyType;
}
