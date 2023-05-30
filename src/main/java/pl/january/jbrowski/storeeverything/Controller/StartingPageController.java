package pl.january.jbrowski.storeeverything.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Service.NoteService;
import pl.january.jbrowski.storeeverything.Service.StartingPageService;

import java.time.LocalDateTime;
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
    public String addNote(@ModelAttribute Note noteForm, @RequestParam("user_Id") Long user_Id) {

        Note note = new Note(
                noteForm.getTitle(),
                user_Id,
                noteForm.getContent(),
                noteForm.getLink(),
                LocalDateTime.now().toString(),
                noteForm.getCategory()
        );
        return noteService.addNote(note);
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

    @GetMapping("/Welcome")
    public String welc(Model model, HttpSession httpSession) {
        return noteService.welc(model, httpSession);
    }

    @GetMapping("/notes/{id}/delete")
    public String deleteNote(@PathVariable("id") Long noteId) {
        noteService.deleteNoteById(noteId);
        return "redirect:/notes";
    }
}
