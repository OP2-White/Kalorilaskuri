package Kalorilaskuri;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import Kalorilaskuri.Domain.Food;
import Kalorilaskuri.Domain.FoodEaten;
import Kalorilaskuri.Domain.AppUser;
import Kalorilaskuri.Domain.FoodRepository;
import Kalorilaskuri.Domain.FoodEatenRepository;
import Kalorilaskuri.Domain.AppUserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class KalorilaskuriApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodRepository foodRepository;

    @MockBean
    private FoodEatenRepository foodEatenRepository;

    @MockBean
    private AppUserRepository appUserRepository;

    @MockBean
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveFood() throws Exception {
        Food food = new Food("Apple", 52, 0, 14, 0, 10);
        when(foodRepository.save(any(Food.class))).thenReturn(food);

        mockMvc.perform(MockMvcRequestBuilders.post("/saveFoodREST")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(food)))
            .andExpect(status().isOk())
            .andExpect(content().string("Data saved successfully"));
    }

    @Test
    void testFoodListRest() throws Exception {
        List<Food> foods = Arrays.asList(new Food("Apple", 52, 0, 14, 0, 10));
        when(foodRepository.findAll()).thenReturn(foods);

        mockMvc.perform(MockMvcRequestBuilders.get("/foodListREST"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].foodName").value("Apple"));
    }

    @Test
    void testFoodByIdRest() throws Exception {
        Long foodId = 1L;
        Optional<Food> food = Optional.of(new Food("Apple", 52, 0, 14, 0, 10));
        when(foodRepository.findByFoodId(foodId)).thenReturn(food);

        mockMvc.perform(MockMvcRequestBuilders.get("/foodREST/" + foodId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.foodName").value("Apple"));
    }

    @Test
    void testDeleteFood() throws Exception {
        Long foodId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteFoodREST/" + foodId))
            .andExpect(status().isOk())
            .andExpect(content().string("Food deleted successfully"));
    }

    @Test
    void testSaveFoodEaten() throws Exception {
        FoodEaten foodEaten = new FoodEaten("2022-01-01", "Apple", 52, 0, 14, 0, 10, new AppUser( "moi", "moi"));
        when(foodEatenRepository.save(any(FoodEaten.class))).thenReturn(foodEaten);

        mockMvc.perform(MockMvcRequestBuilders.post("/saveFoodEatenREST")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(foodEaten)))
            .andExpect(status().isOk())
            .andExpect(content().string("Data saved successfully"));
    }

    @Test
    void testFoodListEatenFoodsRest() throws Exception {
        List<FoodEaten> foodEatenList = Arrays.asList(new FoodEaten("2022-01-01", "Apple", 52, 0, 14, 0, 10, new AppUser("moi", "moi")));
        when(foodEatenRepository.findAll()).thenReturn(foodEatenList);

        mockMvc.perform(MockMvcRequestBuilders.get("/eatenFoodListREST"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].foodName").value("Apple"));
    }
}
