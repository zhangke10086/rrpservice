package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@Data
public class City {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "provinceid")
    private String provinceid;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Integer value;
    @Column(name = "cityid")
    private String cityid;
}
