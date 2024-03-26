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
   private String foodName;
   private int calories;
   private int protein;
   private int carbs;
   private int fat;

   public FoodEaten() {

   }

   

public FoodEaten(String date, String foodName, int calories, int protein, int carbs, int fat) {
    this.date = date;
    this.foodName = foodName;
    this.calories = calories;
    this.protein = protein;
    this.carbs = carbs;
    this.fat = fat;
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

public String getFoodName() {
    return foodName;
}

public void setFoodName(String foodName) {
    this.foodName = foodName;
}

public int getCalories() {
    return calories;
}

public void setCalories(int calories) {
    this.calories = calories;
}

public int getProtein() {
    return protein;
}

public void setProtein(int protein) {
    this.protein = protein;
}

public int getCarbs() {
    return carbs;
}

public void setCarbs(int carbs) {
    this.carbs = carbs;
}

public int getFat() {
    return fat;
}

public void setFat(int fat) {
    this.fat = fat;
}



@Override
public String toString() {
    return "FoodEaten [id=" + id + ", date=" + date + ", foodName=" + foodName + ", calories=" + calories + ", protein="
            + protein + ", carbs=" + carbs + ", fat=" + fat + "]";
}



   

}
