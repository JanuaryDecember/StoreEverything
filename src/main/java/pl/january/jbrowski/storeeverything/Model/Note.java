package pl.january.jbrowski.storeeverything.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "user_Id")
    private Long userrId;
    private String content;
    private String publication_date;
    private String link;
    private String category;
    public Note(String title, Long user_Id, String content, String link, String publication_date, String category) {
        this.title = title;
        this.content = content;
        this.userrId = user_Id;
        this.link = link;
        this.publication_date = publication_date;
        this.category = category;
    }
}
