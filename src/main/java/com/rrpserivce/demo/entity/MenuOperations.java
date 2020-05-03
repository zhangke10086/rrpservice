package com.rrpserivce.demo.entity;

import io.swagger.models.auth.In;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MenuOperations {
    private int menu;
    private Set<Integer> operations;

    public int getMenu() {
        return menu;
    }

    public Set<Integer> getOperations() {
        return operations;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public void setOperations(Set<Integer> operations) {
        this.operations = operations;
    }

    public void addOperation(Integer operation) {
        this.operations.add(operation);
    }

    public MenuOperations(int menu) {
        this.menu = menu;
        this.operations = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuOperations that = (MenuOperations) o;
        return menu == that.menu &&
                operations.equals(that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, operations);
    }
}
