package Kalorilaskuri.Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private String foodName;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private int sugar;

public Food () {
}
    public Food (String foodName, int calories, int protein, int carbs, int fat) {
        super();
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }
    public Long getFoodId() {
        return foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
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
    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    
    
}
