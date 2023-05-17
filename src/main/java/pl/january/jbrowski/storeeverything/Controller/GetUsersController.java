package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.Service.GetUsersService;

@RestController
public class GetUsersController {
    private final GetUsersService getUsersService;

    public GetUsersController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @GetMapping("/")
    public String hello() {
        return getUsersService.hello();
    }
}
