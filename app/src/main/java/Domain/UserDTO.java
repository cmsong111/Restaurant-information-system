package com.galaxy.Restaurantinformationsystem.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private long UPK;
    private String ID;
    private String password;
    private String name;
    private int age;
    private boolean isAdmin;
    List<Long> SPK;
    List<Long> RPK;
}
