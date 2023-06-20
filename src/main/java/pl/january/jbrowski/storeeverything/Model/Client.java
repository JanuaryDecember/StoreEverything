package pl.january.jbrowski.storeeverything.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   // @NotNull
    @Column(name = "name")
    @Size(min = 2, max = 120)
    private String name;
   // @NotNull
    @Column(name = "surname")
    @Size(min = 2, max = 120)
    private String surname;
   // @NotNull
    @Column(name = "login")
    @Size(min = 4)
    private String login;
   // @NotNull
    @Column(name = "password")
    @Size(min = 4)
    private String password;
  //  @DecimalMin("1")
    @Column(name = "age")
    private String age;

    public Client(String name, String surname, String login, String password, String age) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.age = age;
    }
}
