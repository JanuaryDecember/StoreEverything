package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.Service.LoginService;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(){
        return loginService.login();
    }
}
