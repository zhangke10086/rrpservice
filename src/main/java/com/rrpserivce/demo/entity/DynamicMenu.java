package com.rrpserivce.demo.entity;


import java.io.Serializable;
import java.util.Set;

public class DynamicMenu implements Serializable, Comparable<DynamicMenu> {
    private Menu menu;
    private Set<Menu> children;

    public DynamicMenu(Menu menu) {
        this.menu = menu;
    }

    public DynamicMenu(Menu menu, Set<Menu> menus) {
        this.menu = menu;
        this.children = menus;
    }

    public Menu getMenu() {
        return menu;
    }

    public Set<Menu> getChildren() {
        return children;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(DynamicMenu dynamicMenu) {
//        int result = this.menu.compareTo(dynamicMenu.getMenu());
        return this.menu.compareTo(dynamicMenu.getMenu());
    }
}
