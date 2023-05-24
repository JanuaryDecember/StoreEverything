package pl.january.jbrowski.storeeverything.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;
import java.util.Optional;

@Service
public class SignUpService {

    public boolean registerUser(String username, String email, String password) {
        return true;
    }
}
