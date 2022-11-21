package com.galaxy.Restaurantinformationsystem.DTO;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StoreDTO {
    private Long SPK;
    private String name;
    private String call;
    private String location1;
    private String location2;
    private String location3;
    private String category;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean kids;
    private boolean price;
    private boolean tasty;
    private boolean roleModel;
    private double locationX;
    private double locationY;
    private List<Long> reviews = new ArrayList<>();
    private List<Long> menus = new ArrayList<>();
    private Long UPK;
}


