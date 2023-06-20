package pl.january.jbrowski.storeeverything.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    private Long clientid;
    @Column(name = "content")
    private String content;
    private String publicationdate;
    @Column(name = "link")
    private String link;
    @Column(name = "category")
    private String category;

    public Note(String title, Long clientid, String content, String link, String publicationdate, String category) {
        this.title = title;
        this.content = content;
        this.clientid = clientid;
        this.link = link;
        this.publicationdate = publicationdate;
        this.category = category;
    }


}
