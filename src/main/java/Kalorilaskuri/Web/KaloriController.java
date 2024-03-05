package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Kalorilaskuri.Domain.FoodRepository;
import Kalorilaskuri.Domain.Food;
import java.util.List;
import java.util.Optional;

@Controller
public class KaloriController {
    
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/")
    public String home() {
        return "foodListRest"; 
    }

    @CrossOrigin
    @RequestMapping(value = "/foodListRest", method = RequestMethod.GET)
    public @ResponseBody List <Food> foodListRest() {
        return(List<Food>) foodRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value="foodREST/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Food> foodByIdRest(@PathVariable Long id) {
        return foodRepository.findById(id);
    }

    @CrossOrigin
    @RequestMapping(value="saveFoodREST", method = RequestMethod.POST)
    public @ResponseBody Food saveFoodRest(@RequestBody Food food) {
        return foodRepository.save(food);
    }


    }

