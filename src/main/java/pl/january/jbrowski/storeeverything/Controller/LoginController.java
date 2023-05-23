package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.User;
import pl.january.jbrowski.storeeverything.Service.LoginService;


@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
/*
    public String login(){
        return loginService.login();
    }

 */
    //Przekazanie nazwy uzytkownika na home page, najpierw sprawdzic czy podane dane do logowania sa w bazie danych
    public String Dane(@RequestParam("username") String username, @RequestParam("password")String password, Model model) {
        User user = new User(username, password);
        model.addAttribute("username", user.getNazwa());
        return "HomePage";
    }
}
