package com.example.products.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "products")

//cria GETTERS, SETTERS e CONSTRUTORES padrão automaticamente
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String title;

    private int price_in_cents;

    public Product(RequestProductDTO requestProductDTO){
        this.title = requestProductDTO.title();
        this.price_in_cents = requestProductDTO.price_in_cents();
    }
}
