package pl.january.jbrowski.storeeverything.Service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.CategoryRepository;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;

import java.util.Optional;

    @Service
    @AllArgsConstructor
    public class LoginService {
        private final ClientRepository clientRepository;
        private final CategoryRepository categoryRepository;

        public String login(String login, String password, HttpSession httpSession) {
            Optional<Client> client = clientRepository.findAll().stream().filter(a -> (a.getLogin().equals(login) && a.getPassword().equals(password))).findFirst();
            if(client.isEmpty()){
                return "failedtologin";
            }
            httpSession.setAttribute("name", client.get().getName());
            httpSession.setAttribute("user_Id", client.get().getId());
            httpSession.setAttribute("categories", categoryRepository.findAll());
            return "redirect:/Welcome";
        }
        public String loginAdmin(String login, String password, HttpSession httpSession){
            if(login.equals("admin") && password.equals("admin")){
                return "Admin";
            }
            else return "failedtologin";
        }
    }
