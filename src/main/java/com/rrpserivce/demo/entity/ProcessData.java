package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "process_data")
@Data
public class ProcessData {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private Double concrete_density;
    @Column()
    private Double concrete_angle;
    @Column()
    private Double concrete_thickness;
    @Column()
    private Double concrete_delay;
    @Column()
    private Double zero_X;
    @Column()
    private Double zero_Y;
    @Column()
    private Double zero_Z;
    @Column()
    private Double concretrreceive_coordinate_x;
    @Column()
    private Double concretrreceive_coordinate_y;
    @Column()
    private Double concretrreceive_coordinate_z;
    @Column()
    private Double crop_width_y;
    @Column()
    private Double crop_height_x;
    @Column()
    private Double crop_X_notpositive_distance;
    @Column()
    private Double enddistance;
    @ManyToOne()
    private Bench bench;

}

