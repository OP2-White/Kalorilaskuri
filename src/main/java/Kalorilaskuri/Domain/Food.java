package Kalorilaskuri.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FoodId;
    private String FoodName;
    private int Calories;
    private int Protein;
    private int Carbs;
    private int Fat;


    public Food (String FoodName, int Calories, int Protein, int Carbs, int Fat) {
        super();
        this.FoodName = FoodName;
        this.Calories = Calories;
        this.Protein = Protein;
        this.Carbs = Carbs;
        this.Fat = Fat;
    }


    public Long getFoodId() {
        return FoodId;
    }


    public void setFoodId(Long foodId) {
        FoodId = foodId;
    }


    public String getFoodName() {
        return FoodName;
    }


    public void setFoodName(String foodName) {
        FoodName = foodName;
    }


    public int getCalories() {
        return Calories;
    }


    public void setCalories(int calories) {
        Calories = calories;
    }


    public int getProtein() {
        return Protein;
    }


    public void setProtein(int protein) {
        Protein = protein;
    }


    public int getCarbs() {
        return Carbs;
    }


    public void setCarbs(int carbs) {
        Carbs = carbs;
    }


    public int getFat() {
        return Fat;
    }


    public void setFat(int fat) {
        Fat = fat;
    }
    



    
}
