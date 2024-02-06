package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import Kalorilaskuri.Domain.FoodRepository;

@Controller
public class KaloriController {
    
    @Autowired
    private FoodRepository foodRepository;
}
