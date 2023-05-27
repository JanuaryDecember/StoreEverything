package pl.january.jbrowski.storeeverything.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Service.NoteService;
import pl.january.jbrowski.storeeverything.Service.StartingPageService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class StartingPageController {
    private final StartingPageService startingPageService;
    private final NoteService noteService;

    public StartingPageController(StartingPageService startingPageService, NoteService noteService) {
        this.startingPageService = startingPageService;
        this.noteService = noteService;
    }

    @GetMapping("/StartingPage")
    public String welcome() {
        return startingPageService.welcome();
    }

    @GetMapping("/notes")
    public String showNotes(Model model) {
        List<Note> userNotes = noteService.getUserNotes();
        model.addAttribute("userNotes", userNotes);
        return "Welcome";
    }

    @PostMapping("/notes/add")
    public String addNote(@ModelAttribute Note noteForm) {
        Note note = new Note(
                noteForm.getTitle(),
                noteForm.getContent(),
                noteForm.getLink(),
                LocalDate.now().toString(),
                noteForm.getCategory()
        );

        noteService.addNote(note);
        return "redirect:/notes";
    }

    @PostMapping("/notes/{id}/edit")
    public String editNote(@PathVariable("id") Long noteId, @ModelAttribute Note noteForm) {
        Note note = noteService.getNoteById(noteId);
        if (note == null) {
            return "redirect:/notes";
        }
        note.setTitle(noteForm.getTitle());
        note.setContent(noteForm.getContent());
        note.setLink(noteForm.getLink());
        note.setCategory(noteForm.getCategory());
        noteService.updateNote(note);
        return "redirect:/notes";
    }

    @PostMapping("/notes/{id}/delete")
    public String deleteNote(@PathVariable("id") Long noteId) {
        noteService.deleteNoteById(noteId);
        return "redirect:/notes";
    }
}
