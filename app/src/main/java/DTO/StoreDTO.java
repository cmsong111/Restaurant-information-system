//package com.galaxy.Restaurantinformationsystem.DTO;
package DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class StoreDTO {
    private Long SPK;
    private String name;
    private String call;
    private String location1;
    private String location2;
    private String location3;
    private String category;

    @JsonFormat(pattern = "hh:mm:ss")
    private String startTime;
    private String endTime;
    private boolean kids;
    private boolean price;
    private boolean tasty;
    private boolean roleModel;
    private double locationX;
    private double locationY;
    private List<Long> reviews = new ArrayList<>();
    private List<Long> menus = new ArrayList<>();
    private Long UPK;
    private String image;
}


