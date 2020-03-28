package com.rrpserivce.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnose")
@Data
public class Diagnose {
    @Id
    @Column(name = "id")
    private int id;
    @Column()
    private Boolean vibrationtable_button0;
    @Column()
    private Boolean vibrationtable_button1;
    @Column()
    private Boolean vibrationtable_button2;
    @Column()
    private Boolean vibrationtable_button5;
    @Column()
    private Boolean vibrationtable_button6;
    @Column()
    private Boolean vibrationtable_button7;
    @Column()
    private Boolean vibrationtable_signal0;
    @Column()
    private Boolean vibrationtable_signal1;
    @Column()
    private Boolean vibrationtable_signal2;
    @Column()
    private Boolean vibrationtable_signal3;
    @Column()
    private Boolean vibrationtable_signal4;
    @Column()
    private Boolean vibrationtable_signal5;
    @Column()
    private Boolean allmanualauto1;
    @Column()
    private Boolean allmanualauto2;
    @Column()
    private Boolean allmanualauto3;
    @Column()
    private Boolean safetymask_signal0;
    @Column()
    private Boolean safetymask_signal1;
    @Column()
    private Boolean safetymask_signal2;
    @Column()
    private Boolean safetymask_signal3;
    @Column()
    private Boolean cameratrigger;
    @Column()
    private Boolean vibration_startlocation;
    @Column()
    private Boolean tabledrive_signal0;
    @Column()
    private Boolean tabledrive_signal1;
    @Column()
    private Boolean tabledrive_signal2;
    @Column()
    private Boolean tabledrive_signal3;
    @Column()
    private Boolean tabledrive_signal4;
    @Column()
    private Boolean IO2_DO0;
    @Column()
    private Boolean IO2_DO1;
    @Column()
    private Boolean IO2_DO2;
    @Column()
    private Boolean IO2_DO3;
    @Column()
    private Boolean IO2_DO4;
    @Column()
    private Boolean IO2_DO5;
    @Column()
    private Boolean IO2_DO6;
    @Column()
    private Boolean IO2_DO7;
    @Column()
    private Boolean IO2_DO8;
    @Column()
    private Boolean IO2_DO9;
    @Column()
    private Boolean IO2_DO10;
    @Column()
    private Boolean IO2_DO11;
    @Column()
    private Boolean IO2_DO16;
    @Column()
    private Boolean IO2_DO17;
    @Column()
    private Boolean IO2_DO18;
    @Column()
    private Boolean IO2_DO19;
    @Column()
    private Boolean IO2_DO20;
    @Column()
    private Boolean IO2_DO21;
    @Column()
    private Boolean IO2_DO22;
    @Column()
    private Boolean IO2_DO23;
    @Column()
    private Boolean IO2_DO24;
    @Column()
    private Boolean IO2_DO25;
    @Column()
    private Boolean IO2_DO26;
    @Column()
    private Boolean IO2_DO27;
    @Column()
    private Boolean IO2_DO28;
    @Column()
    private Boolean IO2_DO29;
    @Column()
    private Boolean IO2_DO30;
    @Column()
    private Boolean IO2_DO31;
    @Column()
    private Integer startlocation;
    @Column()
    private Integer startlocation_stop;
    @Column()
    private Double machine_port_speed0;
    @Column()
    private Double machine_port_speed1;
    @Column()
    private Double machine_port_speed2;
    @Column()
    private Double machine_port_speed3;
    @Column()
    private Double machine_port_speed4;
    @Column()
    private Double machine_port_speed5;
    @Column()
    private Double machine_port_speed6;
    @Column()
    private Double machine_port_speed7;
    @Column()
    private Double useweight;
    @Column()
    private Double Getencodervalue_X;
    @Column()
    private Double Getencodervalue_Y;
    @Column(length = 255)
    private String IP;
    @Column()
    private Boolean machine_button0;
    @Column()
    private Boolean machine_button1;
    @Column()
    private Boolean machine_button2;
    @Column()
    private Boolean machine_button3;
    @Column()
    private Boolean machine_button4;
    @Column()
    private Boolean machine_button5;
    @Column()
    private Boolean machine_button6;
    @Column()
    private Boolean machine_button7;
    @Column()
    private Boolean machine_signal0;
    @Column()
    private Boolean machine_signal1;
    @Column()
    private Boolean machine_signal2;
    @Column()
    private Boolean machine_signal3;
    @Column()
    private Boolean machine_signal4;
    @Column()
    private Boolean machine_signal5;
    @Column()
    private Boolean machine_signal6;
    @Column()
    private Boolean machine_signal7;
    @Column()
    private Boolean machine_signal8;
    @Column()
    private Boolean machine_signal9;
    @Column()
    private Boolean machine_signal10;
    @Column()
    private Boolean machine_signal11;
    @Column()
    private Boolean machine_signal12;
    @Column()
    private Boolean machine_signal13;
    @Column()
    private Boolean machine_signal14;
    @Column()
    private Boolean machine_signal15;
    @Column()
    private Boolean machine_signal16;
    @Column()
    private Boolean machine_signal17;
    @Column()
    private Boolean machine_signal18;
    @Column()
    private Boolean machine_signal19;
    @Column()
    private Boolean machine_signal20;
    @Column()
    private Boolean machine_signal21;
    @Column()
    private Boolean machine_signal22;
    @Column()
    private Boolean machine_signal23;
    @Column()
    private Boolean machine_portdoor0;
    @Column()
    private Boolean machine_portdoor1;
    @Column()
    private Boolean machine_portdoor2;
    @Column()
    private Boolean machine_portdoor3;
    @Column()
    private Boolean machine_portdoor4;
    @Column()
    private Boolean machine_portdoor5;
    @Column()
    private Boolean machine_portdoor6;
    @Column()
    private Boolean machine_portdoor7;
    @Column()
    private Boolean machine_portdoor8;
    @Column()
    private Boolean machine_portdoor9;
    @Column()
    private Boolean machine_portdoor10;
    @Column()
    private Boolean machine_portdoor11;
    @Column()
    private Boolean machine_portdoor12;
    @Column()
    private Boolean machine_portdoor13;
    @Column()
    private Boolean machine_portdoor14;
    @Column()
    private Boolean machine_portdoor15;
    @Column()
    private Boolean machine_portdoor16;
    @Column()
    private Boolean machine_portdoor17;
    @Column()
    private Boolean machine_origin0;
    @Column()
    private Boolean machine_origin1;
    @Column()
    private Boolean IO7_DO0;
    @Column()
    private Boolean IO7_DO1;
    @Column()
    private Boolean IO7_DO2;
    @Column()
    private Boolean IO7_DO4;
    @Column()
    private Boolean IO7_DO5;
    @Column()
    private Boolean IO7_DO6;
    @Column()
    private Boolean IO7_DO7;
    @Column()
    private Boolean IO7_DO8;
    @Column()
    private Boolean IO7_DO9;
    @Column()
    private Boolean IO7_DO11;
    @Column()
    private Boolean IO7_DO12;
    @Column()
    private Boolean IO7_DO14;
    @Column()
    private Boolean IO7_DO15;
    @Column()
    private Boolean IO7_DO16;
    @Column()
    private Boolean IO7_DO17;
    @Column()
    private Boolean IO7_DO18;
    @Column()
    private Boolean IO7_DO19;
    @Column()
    private Boolean IO7_DO20;
    @Column()
    private Boolean IO7_DO21;
    @Column()
    private Boolean IO7_DO22;

}

