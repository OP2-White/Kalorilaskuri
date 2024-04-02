package Kalorilaskuri.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Kalorilaskuri.Domain.Signup;
import Kalorilaskuri.Domain.User;
import Kalorilaskuri.Domain.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(Signup signup) {
        if (!signup.getPassword().equals(signup.getPasswordCheck())) {
            return "redirect:/signup?error";
        }

        User user = new User(signup.getUsername(), signup.getPassword(), signup.getRole());
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(Signup signup) {
        User user = userRepository.findByUsername(signup.getUsername());
        if (user != null && user.getPasswordHash().equals(signup.getPassword())) {
            // Kirjautuminen onnistui
            return "redirect:/foodListRest";
        } else {
            // Kirjautuminen epäonnistui
            return "redirect:/login?error";
        }
    }
}

