package com.example.products.domain.user;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "users")
@Entity(name = "users")

//cria GETTERS, SETTERS e CONSTRUTORES padrão automaticamente
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    private String password;

    private String role;

    public User(RequestUserDTO requestUserDTO) {
        this.name = requestUserDTO.name();
        this.password = requestUserDTO.password();
        this.role = requestUserDTO.role();
    }
}

