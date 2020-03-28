package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "command")
@Data
public class Command {
    @Id
    @Column(name = "id")
    private int id;
    @Column(length = 255)
    private String description;
    @Column()
    private Date time;
    @Column(length = 16)
    private String status;

}

