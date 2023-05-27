package pl.january.jbrowski.storeeverything.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.january.jbrowski.storeeverything.Model.Note;
import pl.january.jbrowski.storeeverything.Repositories.NoteRepository;

import java.util.Optional;
import java.util.ArrayList;
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

    public void addNote(Note note) {
        noteRepository.save(note);
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
}