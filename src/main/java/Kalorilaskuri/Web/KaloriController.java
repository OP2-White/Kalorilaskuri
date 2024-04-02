package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Kalorilaskuri.Domain.FoodRepository;
import Kalorilaskuri.Domain.AppUserRepository;
import Kalorilaskuri.Domain.FoodEatenRepository;
import Kalorilaskuri.Domain.Food;
import Kalorilaskuri.Domain.FoodEaten;
import Kalorilaskuri.Domain.AppUser;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class KaloriController {

    Logger logger = LoggerFactory.getLogger(KaloriController.class);
    
    @Autowired
    private FoodRepository foodRepository;
   
    @Autowired
    private FoodEatenRepository foodEatenRepository;

    @Autowired
    private AppUserRepository AppUserRepository;
// @CrossOrigin
// @RequestMapping(value = "/", method = RequestMethod.GET)
//     public String home() {
//         return "foodListRest"; 
//     }

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
    public ResponseEntity<String> saveFoodEatenRest(@RequestBody FoodEaten foodEaten) {
        try {
            // Save the food data to the database
            foodEatenRepository.save(foodEaten);
            
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
    @RequestMapping(value = "/eatenFoodListREST", method = RequestMethod.GET)
    public @ResponseBody List <FoodEaten> foodListEatenFoodsRest() {
        return(List<FoodEaten>) foodEatenRepository.findAll();
    }

    //DELETE TOIMINNALLISUUS
    @CrossOrigin
    @RequestMapping(value = "/deleteFoodREST/{foodId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFoodRest(@PathVariable("foodId") Long foodId) {
        try {
            // Tässä voit käyttää foodRepositoryn deleteById-metodia poistaaksesi ruoan
            foodRepository.deleteById(foodId);
            
            // Palauta onnistunut vastaus
            return ResponseEntity.ok("Food deleted successfully");
        } catch (Exception e) {
            // Lokita poikkeus virheenkorjaustarkoituksiin
            e.printStackTrace();

            // Palauta virheellinen vastaus tarkalla virhesanomalla
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting food: " + e.getMessage());
        }
    }
    //endpoint for making a new user
    @CrossOrigin
    @RequestMapping(value="/users", method = RequestMethod.POST)
   public AppUser AddUsersRest(@RequestBody AppUser user){
    AppUser newUser = new AppUser(user.getUsername(), user.getPasswordHash());

    AppUserRepository.save(newUser);
       return newUser;
   }

   // GET REST endpoint for calling users by id as json.
	@CrossOrigin
    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
   public ResponseEntity<Optional<AppUser>> findusersRest(@PathVariable("id")Long userId){
       Optional<AppUser> user = AppUserRepository.findById(userId);
       return ResponseEntity.ok().body(user);
   }

    // PUT REST endpoint for updating the userData
    @CrossOrigin
	 @RequestMapping(value="/users", method = RequestMethod.PUT)
    public ResponseEntity<AppUser> modifyUserRest(@RequestBody AppUser user){
        Long userId = user.getUserId();
        if (AppUserRepository.existsById(userId)) {
            AppUser modifiedUser = AppUserRepository.save(user);
            return ResponseEntity.ok().body(modifiedUser);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @CrossOrigin
     @PostMapping("/checkLoginRequest")
    public ResponseEntity<AppUser> checkLoginRequest(@RequestBody AppUser user) {
        logger.info("User.getUsername()=> ", user.getUsername());
        AppUser appuser = AppUserRepository.findByUsername(user.getUsername());
        logger.info("user.getPasswordHash()=> ", user.getPasswordHash());
        logger.info("appuser.getPasswordHash()=> ", appuser.getPasswordHash());
        if (appuser != null) {
            if (user.getPasswordHash().equals(appuser.getPasswordHash()) ) {
                return ResponseEntity.ok(appuser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else { 
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    }

