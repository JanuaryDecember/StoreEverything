package pl.january.jbrowski.storeeverything.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.january.jbrowski.storeeverything.Model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String Name);

}
