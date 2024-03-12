package Kalorilaskuri.Domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface FoodRepository extends JpaRepository <Food, Long> {
    Optional<Food> findById(Long id);
    Optional<Food> findByFoodName(String foodName);
   

}
