package pl.january.jbrowski.storeeverything.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;
import pl.january.jbrowski.storeeverything.Service.SignUpService;

import java.util.Optional;

@Controller
@Validated
@AllArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;
    private final ClientRepository clientRepository;


    @GetMapping("/signup")
    public String sgUp() {
        return signUpService.signUp();
    }
    @GetMapping("/AdminView")
    public String admViwe(){
        return "AdminLogin";
    }

    @PostMapping("/register")
    public String signUp(@Valid @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("age") String age,
                         Model model) throws InterruptedException {

        Optional<Client> existingClient = clientRepository.findByLogin(username).stream().findAny();
        if (existingClient.isPresent()) {
            model.addAttribute("exists", true);
            return "SignUp";
        }
        try{
            Client client = new Client(name, surname, username, password, age);
            clientRepository.save(client);
        }
        catch (Exception e){
            model.addAttribute("failed", true);
            return "SignUp";
        }
        return "redirect:/";
    }
}
