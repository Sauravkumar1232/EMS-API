package com.example.emsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private Byte age;

}
