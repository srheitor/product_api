package com.example.products.controllers;


import com.example.products.domain.product.Product;
import com.example.products.domain.product.ProductRepository;
import com.example.products.domain.product.RequestProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController

//Define qual tabela irá interagir
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    //Buscar informações do DB
    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    //Enviar informações para o DB
    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Validated RequestProductDTO data){
        Product newProduct = new Product(data);
        System.out.println(data);
        repository.save(newProduct);
        return ResponseEntity.ok(data);
    }
}
