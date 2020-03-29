package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role_menu_ass")
@Data
public class RoleMenu {
    @Id
    @Column(name = "id")
    private int id;
//    @JoinColumn(name = "role_id")
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
//    @JoinColumn(name = "menu_id")
//    @ManyToMany
//    private Set<Menu> menus;
    public RoleMenu(){}
}
