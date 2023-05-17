package pl.january.jbrowski.storeeverything;

public class User {
    private String nazwa;
    private String haslo;

    public User(String nazwa, String haslo){
        this.nazwa = nazwa;
        this.haslo = haslo;
    }
    public String getNazwa(){
        return this.nazwa;
    }
}
