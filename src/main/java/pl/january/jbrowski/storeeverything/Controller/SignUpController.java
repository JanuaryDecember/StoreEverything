package pl.january.jbrowski.storeeverything.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.january.jbrowski.storeeverything.Service.SignUpService;

@Controller
@AllArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;


    @GetMapping("/signup")
    public String sgUp() {
        return signUpService.signUp();
    }

    @PostMapping("/register")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("name") String name,
                         Model model) throws InterruptedException {
        boolean signUpSuccess = signUpService.registerUser(username, email, password, name);

        if (signUpSuccess) {
            model.addAttribute("successMessage", "Registration successful. You can now log in.");
        } else {
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
        }
        return "redirect:/";
    }
}
