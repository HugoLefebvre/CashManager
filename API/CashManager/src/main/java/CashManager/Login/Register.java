package CashManager.Login;

public class Register extends Login {

    String name;

    String surname;
    public Register(Integer id, String email, String password, String name, String surname) {
        super(id, email, password);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
