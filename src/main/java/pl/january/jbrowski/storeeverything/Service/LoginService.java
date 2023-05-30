package pl.january.jbrowski.storeeverything.Service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final ClientRepository clientRepository;

    public String login(String login, String password, HttpSession httpSession) {
        Optional<Client> client = clientRepository.findAll().stream().filter(a -> (a.getLogin().equals(login) && a.getPassword().equals(password))).findFirst();
        httpSession.setAttribute("name", client.get().getName());
        httpSession.setAttribute("user_Id", client.get().getId());
        return "loggedin";
    }
}
