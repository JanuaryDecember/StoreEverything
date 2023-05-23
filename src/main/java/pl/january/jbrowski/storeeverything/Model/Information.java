package pl.january.jbrowski.storeeverything.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Information")
public class Information {
    @Id
    Long id;
    String title;
    String content;
    LocalDateTime publicationDate;
    String category;
}
