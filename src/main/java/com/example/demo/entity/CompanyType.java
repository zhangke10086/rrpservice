package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Company_Type")
@Data
public class CompanyType implements Serializable,Comparable<CompanyType> {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;

    @Override
    public int compareTo(CompanyType o) {
        return this.id - o.id;
    }
}
