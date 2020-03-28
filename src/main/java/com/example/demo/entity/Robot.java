package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "robot")
@Data
public class Robot {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "way")
    private String way;
    @Column(name = "use_situation")
    private String use_situation;
    @OneToOne
    @JoinColumn(name = "belonging_company",referencedColumnName = "id")
    private Company belongingCompany;
}
