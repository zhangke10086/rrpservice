package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "province")
@Data
public class Province {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "provinceid")
    private String provinceid;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Integer value;
}
