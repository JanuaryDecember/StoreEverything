package pl.january.jbrowski.storeeverything.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;

@AllArgsConstructor
@Service
public class SignUpService {
    private final ClientRepository clientRepository;

    public boolean registerUser(String username, String email, String password, String name) {
        clientRepository.save(new Client(username, email, password, name, "18"));
        return true;
    }

    public String signUp() {
        return "SignUp";
    }
}
