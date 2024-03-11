package Kalorilaskuri.Domain;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodEatenRepository extends JpaRepository<FoodEaten, Long> {
    Optional<FoodEaten> findById(Long id);
    FoodEaten save(FoodEaten foodEaten);
}
