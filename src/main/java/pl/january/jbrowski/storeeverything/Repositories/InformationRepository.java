package pl.january.jbrowski.storeeverything.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.january.jbrowski.storeeverything.Model.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
