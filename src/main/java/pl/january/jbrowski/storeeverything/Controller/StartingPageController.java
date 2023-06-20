package pl.january.jbrowski.storeeverything.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Service.NoteService;
import pl.january.jbrowski.storeeverything.Service.StartingPageService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StartingPageController {
    private final StartingPageService startingPageService;
    private final NoteService noteService;

    public StartingPageController(StartingPageService startingPageService, NoteService noteService) {
        this.startingPageService = startingPageService;
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String welcome() {
        return startingPageService.welcome();
    }

    @GetMapping("/notes")
    public String showNotes(Model model) {
        List<Note> userNotes = noteService.getUserNotes();
        model.addAttribute("userNotes", userNotes);

        return "Welcome";
    }

//    @GetMapping("/notes/sort/{}")
//    public String showSortedByNotes(){
//        return "Welcome";
//    }

    @PostMapping("/notes/add")
    public String addNote(@ModelAttribute Note noteForm, @RequestParam("user_Id") Long user_Id) {

        Note note = new Note(
                noteForm.getTitle(),
                user_Id,
                noteForm.getContent(),
                noteForm.getLink(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString(),
                noteForm.getCategory()
        );
        return noteService.addNote(note);
    }

    @GetMapping("/notes/{id}/edit")
    public String showEditNoteForm(@PathVariable("id") Long noteId, Model model) {
        Note note = noteService.getNoteById(noteId);
        if (note == null) {
            return "redirect:/Welcome";
        }
        model.addAttribute("editedNote", note);
        model.addAttribute("noteForm", note);
        return "edit-note-form";
    }

    @PostMapping("/notes/{id}/edit")
    public String editNote(
            @PathVariable("id") Long noteId,
            @ModelAttribute("noteForm") Note noteForm,
            @ModelAttribute("editedNote") Note editedNote) {
        Note note = noteService.getNoteById(noteId);
        if (note == null || editedNote == null || !note.getId().equals(editedNote.getId())) {
            return "redirect:/Welcome";
        }
        note.setTitle(noteForm.getTitle());
        note.setContent(noteForm.getContent());
        note.setLink(noteForm.getLink());
        note.setCategory(noteForm.getCategory());
        noteService.updateNote(note);
        return "redirect:/Welcome";
    }
    @GetMapping("/Welcome")
    public String welc(Model model, HttpSession httpSession) {
        return noteService.welc(model, httpSession);
    }

    @GetMapping("/notes/{id}/delete")
    public String deleteNote(@PathVariable("id") Long noteId) {
        noteService.deleteNoteById(noteId);
        return "redirect:/Welcome";
    }
}
