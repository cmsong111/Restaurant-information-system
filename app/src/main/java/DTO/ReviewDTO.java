//package com.galaxy.Restaurantinformationsystem.DTO;
package DTO;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReviewDTO {

    private Long rpk;
    private String title;
    private String content;
    private String image;
    private Long spk;
    private Long upk;
}
