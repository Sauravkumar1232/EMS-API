package com.example.emsapi.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employe extends BaseModel{
    private String name;
    private String userName;
    private String email;
    private String phone;
    private Byte age;
}
