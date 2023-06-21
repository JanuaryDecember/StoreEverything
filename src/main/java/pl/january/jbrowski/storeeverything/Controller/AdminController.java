package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.january.jbrowski.storeeverything.Model.Category;
import pl.january.jbrowski.storeeverything.Repositories.CategoryRepository;
import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;

@RestController
public class AdminController {

    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public AdminController(ClientRepository clientRepository, CategoryRepository categoryRepository) {
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
    }

    @DeleteMapping("/admin/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        clientRepository.deleteById(userId);
    }

    @PostMapping("/admin/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    @DeleteMapping("/admin/categories")
    public void deleteCategoryByName(@RequestParam("name") String categoryName) {
        Category category = categoryRepository.findByName(categoryName).stream().findAny().get();
        if (category != null) {
            categoryRepository.delete(category);
        }
    }
}