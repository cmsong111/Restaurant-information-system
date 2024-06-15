//package com.galaxy.Restaurantinformationsystem.DTO;
package org.example.data.dto.user;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    List<Long> spk;
    List<Long> rpk;
    private long upk;
    private String id;
    private String password;
    private String name;
    private int age;
    private boolean admin;
}
