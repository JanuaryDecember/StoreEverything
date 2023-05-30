package pl.january.jbrowski.storeeverything.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Service.GetUsersService;

import java.util.List;

@RestController
@AllArgsConstructor
public class GetUserController {
    private final GetUsersService getUsersService;


    @GetMapping("/getUsers")
    public List<Client> hello() {
        return getUsersService.getUsersService();
    }
}
