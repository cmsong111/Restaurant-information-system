//package com.galaxy.Restaurantinformationsystem.DTO;
package DTO;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuDTO {
    private Long mpk;
    private String name;
    private int price;
    private String image;
    private Long spk;
}
