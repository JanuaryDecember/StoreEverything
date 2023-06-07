package pl.january.jbrowski.storeeverything.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import pl.january.jbrowski.storeeverything.Model.Client;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Service.GetUsersService;

import java.util.List;

@Controller
public class EditNoteController {
    @ModelAttribute("noteForm")
    public Note getNoteForm() {
        return new Note();
    }

    @GetMapping("/edit-note-form")
    public String showEditNoteForm() {
        return "edit-note-form";
    }
}
