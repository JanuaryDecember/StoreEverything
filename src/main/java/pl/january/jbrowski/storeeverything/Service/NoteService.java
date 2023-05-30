package pl.january.jbrowski.storeeverything.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Repositories.NoteRepository;

import java.util.Optional;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getUserNotes() {
        return noteRepository.findAll();
    }

    public String addNote(Note note) {
        noteRepository.save(note);
        return "redirect:/notes";
    }

    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNoteById(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    public Note getNoteById(Long noteId) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        return optionalNote.orElse(null);
    }

    public String welc(Model model, HttpSession httpSession) {
        model.addAttribute("name",httpSession.getAttribute("name"));
        model.addAttribute("user_Id",httpSession.getAttribute("user_Id"));
        model.addAttribute("userNotes", noteRepository.findByUserrId((Long)model.getAttribute("user_Id")));
        return "Welcome";
    }
}