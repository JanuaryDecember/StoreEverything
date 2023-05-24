package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.Service.LoginService;

import java.util.Optional;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password") String password, Model model){
        return loginService.login(username, password, model);
    }
}