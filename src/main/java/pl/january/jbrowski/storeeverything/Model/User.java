package pl.january.jbrowski.storeeverything.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String name;
    @Column
    String surname;
    @Column
    int age;
    @Column
    int phoneNumber;
    @Column
    String email;
    @Column
    String address;

}
