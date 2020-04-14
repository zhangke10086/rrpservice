package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    // 反正都肯定是，可以不加参照
    @Column(name = "operation_id")
    private int operation;
    @Column(name = "role_menu_ass_id")
    private int roleMenu;
//    @OneToOne
//    @JoinColumn(name = "operation_id",referencedColumnName = "id")
//    private Operation operation;
//    @OneToOne
//    @JoinColumn(name = "role_menu_ass_id",referencedColumnName = "id")
//    private RoleMenu roleMenu;
//    public Authority() {}

    public Authority() {}
    public Authority(int operation, int roleMenu) {
        this.operation = operation;
        this.roleMenu = roleMenu;
    }
}
