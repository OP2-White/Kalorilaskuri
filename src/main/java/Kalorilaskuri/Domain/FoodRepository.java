package Kalorilaskuri.Domain;

import Food;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository <Food, Long> {
    List<Food> findByFoodId(Long FoodId);

}
