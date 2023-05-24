package pl.january.jbrowski.storeeverything.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.january.jbrowski.storeeverything.Service.SignUpService;

@Controller
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/register")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         Model model) {
        boolean signUpSuccess = signUpService.registerUser(username, email, password);

        if (signUpSuccess) {
            model.addAttribute("successMessage", "Registration successful. You can now log in.");
        } else {
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
        }

        return "StartingPage";
    }
}
