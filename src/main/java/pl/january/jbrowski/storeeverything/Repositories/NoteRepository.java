package pl.january.jbrowski.storeeverything.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.january.jbrowski.storeeverything.Model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
