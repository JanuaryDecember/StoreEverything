package pl.january.jbrowski.storeeverything.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Repositories.NoteRepository;

import java.util.*;

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
        return "redirect:/Welcome";
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
    public List<Note> getSortedNotes(String sortField, Sort.Direction direction, Long clientId) {
        Sort sort = Sort.by(direction, sortField);
        return noteRepository.findByClientid(clientId, sort);
    }


    public String welc(Model model, HttpSession httpSession) {
        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("user_Id", httpSession.getAttribute("user_Id"));

        Sort.Direction defaultDirection = Sort.Direction.ASC;
        String defaultSortField = "publicationdate";

        Sort sort = Sort.by(defaultDirection, defaultSortField);
        Long clientId = (Long) model.getAttribute("user_Id");
        model.addAttribute("clientId", clientId);
        model.addAttribute("userNotes", getSortedNotes(defaultSortField, defaultDirection, clientId));

        return "Welcome";
    }


}