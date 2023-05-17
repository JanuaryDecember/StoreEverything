package pl.january.jbrowski.storeeverything.Service;

import org.springframework.stereotype.Service;

@Service
public class StartingPageService {
    public String welcome(){
        return "StartingPage";
    }
}
