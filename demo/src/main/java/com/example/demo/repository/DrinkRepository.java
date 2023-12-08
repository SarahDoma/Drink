package com.example.demo.repository;

import com.example.demo.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
//    List<Drink> findDrinkByPriceGreaterThan(int price);
}
