package com.rrpserivce.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "menu")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Menu implements Serializable, Comparable<Menu> {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String title;
    @Column(name = "url")
    private String url;
//    @JoinColumn(name = "menu_id",referencedColumnName = "id")
//    @OneToOne
//    private Menu menu;
    @Column(name = "menu_id")
    private String menu;

    public int getId() {
        return id;
    }

    public String getMenu() {
        return menu;
    }
//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "role_menu_ass",
//            joinColumns = {@JoinColumn(name = "menu_id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id")}
//    )
//    private Set<Role> roles = new HashSet<>();

    public Menu() {
    }



//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setMenu(Menu menu) {
//        this.menu = menu;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }

    @Override
    public int compareTo(Menu o) {
        return this.id - o.id;
    }
}
