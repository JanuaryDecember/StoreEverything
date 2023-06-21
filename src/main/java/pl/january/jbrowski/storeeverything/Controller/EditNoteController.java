package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.january.jbrowski.storeeverything.Model.Note;

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
