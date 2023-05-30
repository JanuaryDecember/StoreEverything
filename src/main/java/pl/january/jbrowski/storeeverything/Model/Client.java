package pl.january.jbrowski.storeeverything.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Client")
public class Client {
    public Client(String name, String surname, String login, String password, String age){
        this.name = name;
        this.surname = surname;
        this.login=login;
        this.password=password;
        this.age=age;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String age;
}
