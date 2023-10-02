package com.example.cardapio.controller;
// representa as tabelas do banco de dados e as mapeia como banco de dados @Entity
// @Repository define as operaçoes crud
// @Autowired realiza injeçoes dentro da classe
import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data ){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }


    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO:: new).toList();
        return foodList;
    }

}
