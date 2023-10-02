package com.example.cardapio.food;
// herdara tudo do jpa repository
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
