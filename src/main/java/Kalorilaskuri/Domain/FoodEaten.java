package Kalorilaskuri.Domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class FoodEaten {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String date;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "food_eaten_id", referencedColumnName = "id")
   private List<Food> foods;

   public FoodEaten() {

   }

   public FoodEaten(String date, List<Food> foods) {
    this.date = date;
    this.foods = foods;
   }

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public List<Food> getFoods() {
    return foods;
}

public void setFoods(List<Food> foods) {
    this.foods = foods;
}

   

}
