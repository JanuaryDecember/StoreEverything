package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.january.jbrowski.storeeverything.Service.StartingPageService;

@Controller
public class StartingPageController {
    private final StartingPageService startingPageService;

    public StartingPageController(StartingPageService startingPageService) {
        this.startingPageService = startingPageService;
    }

    @GetMapping("/StartingPage")
    public String welcome() {
        return startingPageService.welcome();
    }

}
