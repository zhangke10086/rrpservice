package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_corresponding_operation")
@Data
public class MenuCorrespondingOperation {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "menu")
    private String menu;
    @Column(name = "operation")
    private String operation;
}
