/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {
  @Id
  @Column(length = 36 ,name="id")
  private String id;
  @Column(length = 60)
  private String no;
  @Column(length = 128)
  private String name;
  @Column(length = 128)
  private String remarks;
  @OneToOne
  private Degree degree;
  @OneToOne
  private Department department;





}
