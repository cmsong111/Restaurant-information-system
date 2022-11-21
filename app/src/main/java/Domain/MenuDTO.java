package com.galaxy.Restaurantinformationsystem.DTO;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuDTO {
    private Long MPK;
    private String name;
    private int price;
    private String image;
    private Long SPK;
}
