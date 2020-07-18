package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "warncontent")
@Data
public class WarnContent {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private String name;
    @Column()
    private String description;

}
