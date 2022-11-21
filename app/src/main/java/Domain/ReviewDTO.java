package com.galaxy.Restaurantinformationsystem.DTO;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReviewDTO {

    private Long RPK;
    private String title;
    private String content;
    private String image;
    private Long menuDTO;
    private Long userDTO;


}
