package com.example.listingapprestspring.dto;

import com.example.listingapprestspring.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
}
