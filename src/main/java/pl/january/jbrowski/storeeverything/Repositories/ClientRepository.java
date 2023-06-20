package pl.january.jbrowski.storeeverything.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.january.jbrowski.storeeverything.Model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByLogin(String login);
}
