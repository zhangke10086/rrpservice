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
//    @OneToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id")
//    private Role role;
//    @OneToOne
//    @JoinColumn(name = "menu_id", referencedColumnName = "id")
//    private Menu menu;
    @Column(name = "role_id")
    private int role;
    @Column(name = "menu_id")
    private int menu;



//    @JoinColumn(name = "menu_id")
//    @ManyToMany
//    private Set<Menu> menus;
    public RoleMenu(){}

    public int getId() {
        return id;
    }

    public int getRole() {
        return role;
    }

    public int getMenu() {
        return menu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }
}
