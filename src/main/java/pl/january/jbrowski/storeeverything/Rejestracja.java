package pl.january.jbrowski.storeeverything;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Rejestracja {

@GetMapping("/formularz")
public String Dane(@RequestParam("nazwa") String nazwa, @RequestParam("haslo")String haslo, Model model){
    User user = new User(nazwa, haslo);
    model.addAttribute("nazwa", user.getNazwa() );
    return "welcome";
}
    @GetMapping("/sayhello")
    public String sayHello(Model model){
        System.out.println("say helllo");
        model.addAttribute("a1", "1234");
        return "welcome";
    }
}
