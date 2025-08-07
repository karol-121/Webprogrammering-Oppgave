package webprogrammering.oblig;

public class Ticket {
    private String film;
    private int amount;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public Ticket(String film, int amount, String name, String surname, String phone, String email) {
        this.film = film;
        this.amount = amount;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Ticket() {

    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
