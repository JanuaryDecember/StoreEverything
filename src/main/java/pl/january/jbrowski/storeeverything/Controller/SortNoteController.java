package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Service.NoteService;

import java.util.List;

@Controller
public class SortNoteController {

    private final NoteService noteService;

    public SortNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/sort")
    public ModelAndView getSortedNotes(
            @RequestParam(value = "sortField", defaultValue = "publicationdate") String sortField,
            @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder,
            @RequestParam(value = "clientId") Long clientId) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        List<Note> sortedNotes = noteService.getSortedNotes(sortField, direction, clientId);
        ModelAndView modelAndView = new ModelAndView("Welcome");
        modelAndView.addObject("userNotes", sortedNotes);
        modelAndView.addObject("clientId", clientId);
        return modelAndView;
    }
}

