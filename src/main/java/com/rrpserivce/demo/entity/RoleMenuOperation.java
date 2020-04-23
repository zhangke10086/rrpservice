package com.rrpserivce.demo.entity;

public class RoleMenuOperation {
    private int Role;
    private int Menu;
    private int Operation;

    public int getRole() {
        return Role;
    }

    public int getMenu() {
        return Menu;
    }

    public int getOperation() {
        return Operation;
    }

    public void setRole(int role) {
        Role = role;
    }

    public void setMenu(int menu) {
        Menu = menu;
    }

    public void setOperation(int operation) {
        Operation = operation;
    }

    public RoleMenuOperation(int role, int menu, int operation) {
        Role = role;
        Menu = menu;
        Operation = operation;
    }
}
