package com.example.security.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Boolean status;

    // Constructors, getters, and setters are generated by Lombok
}
