//package com.galaxy.Restaurantinformationsystem.DTO;
package DTO;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private long upk;
    private String id;
    private String password;
    private String name;
    private int age;
    private boolean admin;
    List<Long> spk;
    List<Long> rpk;
}
