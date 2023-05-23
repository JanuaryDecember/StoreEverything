package pl.january.jbrowski.storeeverything.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GetUsersService {
    private final ClientRepository clientRepository;

    public List<Client> getUsersService() {
        return clientRepository.findAll().stream().toList();
    }
}
