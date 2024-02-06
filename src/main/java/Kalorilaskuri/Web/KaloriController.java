package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Kalorilaskuri.Domain.FoodRepository;
import Kalorilaskuri.Domain.Food;

@Controller
public class KaloriController {
    
    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(value = "/foodList", method = RequestMethod.GET)
    public String listFoods(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        return "foodList";
    }
}
