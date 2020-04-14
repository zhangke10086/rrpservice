package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role {
    public Role() {
    }

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_menu_ass",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private Set<Menu> menus = new HashSet<>();
}
