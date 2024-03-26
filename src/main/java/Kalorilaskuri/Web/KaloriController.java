package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Kalorilaskuri.Domain.FoodRepository;
import Kalorilaskuri.Domain.FoodEatenRepository;
import Kalorilaskuri.Domain.Food;
import Kalorilaskuri.Domain.FoodEaten;

import java.util.List;
import java.util.Optional;

@Controller

public class KaloriController {
    
    @Autowired
    private FoodRepository foodRepository;
   
    @Autowired
    private FoodEatenRepository foodEatenRepository;


    @GetMapping("/")
    public String home() {
        return "foodListRest"; 
    }

    @CrossOrigin
    @RequestMapping(value = "/foodListREST", method = RequestMethod.GET)
    public @ResponseBody List <Food> foodListRest() {
        return(List<Food>) foodRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value="foodREST/{foodId}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Food>>  foodByIdRest(@PathVariable("foodId") Long foodId) {
        Optional<Food> food = foodRepository.findByFoodId(foodId);
        return ResponseEntity.ok().body(food);
    }

    @CrossOrigin
    @RequestMapping(value="findByName/{foodName}", method = RequestMethod.GET)
    public @ResponseBody Optional<Food> foodByNameRest(@PathVariable("foodName") String foodName) {
        return foodRepository.findByFoodName(foodName);
    }

    @CrossOrigin
    @RequestMapping(value = "/saveFoodREST", method = RequestMethod.POST)
    public ResponseEntity<String> saveFoodRest(@RequestBody Food food) {
        try {
            // Save the food data to the database
            foodRepository.save(food);
            
            // Return success response
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return an error response with the exact error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value="saveFoodEatenREST", method = RequestMethod.POST)
    public @ResponseBody FoodEaten saveFoodEatenRest(@RequestBody FoodEaten foodEaten) {
        return foodEatenRepository.save(foodEaten);
    }


    }

