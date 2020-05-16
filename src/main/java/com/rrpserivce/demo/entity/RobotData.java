package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "robot_data")
@Data
public class RobotData {
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
    private Double maxv_x;
    @Column()
    private Double maxv_y;
    @Column()
    private Double maxv_z;
    @Column()
    private Double maxv_part;
    @Column()
    private Double encodervalue_zero_X;
    @Column()
    private Double encodervalue_zero_Y;
    @Column()
    private Double encodervalue_zero_Z;
    @Column()
    private Double mincoordinate_x;
    @Column()
    private Double mincoordinate_y;
    @Column()
    private Double mincoordinate_z;
    @Column()
    private Double maxcoordinate_x;
    @Column()
    private Double maxcoordinate_y;
    @Column()
    private Double maxcoordinate_z;
    @Column()
    private Double concretrreceive_coordinate_x;
    @Column()
    private Double concretrreceive_coordinate_y;
    @Column()
    private Double concretrreceive_coordinate_z;
    @Column()
    private Integer vibrate_time;
    @Column()
    private Integer vibration_frequency_1;
    @Column()
    private Double speed_default;
    @Column()
    private Double target_work_port_v;
    @Column()
    private Double move_speed;
    @Column()
    private Double crop_height_x;
    @Column()
    private Double crop_width_y;
    @Column()
    private Double crop_X_notpositive_distance;
    @Column()
    private Double port_work_distance_x;
    @Column()
    private Double port_work_distance_y;
    @Column()
    private Double reversedweight_length;
    @Column()
    private Double reversedweight_lengthpositive;
    @Column()
    private Double time_lubrication;
    @Column()
    private Double Intervals_lubrication;
    @Column()
    private Boolean vibrate_outputs0;
    @Column()
    private Boolean vibrate_outputs1;
    @Column()
    private Boolean vibrate_outputs2;
    @Column()
    private Boolean vibrate_outputs3;
    @Column()
    private Double enddistance;
    @OneToOne
    private Robot robot;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

}

