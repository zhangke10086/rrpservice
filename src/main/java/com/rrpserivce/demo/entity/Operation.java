package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "operation")
@Data
public class Operation {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String name;
    @Column(name = "method")
    private String method;

//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "authority",
//            joinColumns = {@JoinColumn(name = "role_menu_ass_id")},
//            inverseJoinColumns = {@JoinColumn(name = "operation_id")}
//    )
//    private Set<Menu> roles = new HashSet<>();

}
