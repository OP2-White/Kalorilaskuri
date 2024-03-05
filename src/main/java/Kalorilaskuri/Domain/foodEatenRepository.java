package Kalorilaskuri.Domain;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface foodEatenRepository extends JpaRepository <Food, Long> {
    Optional<Food> findById(Long id);
   

}
