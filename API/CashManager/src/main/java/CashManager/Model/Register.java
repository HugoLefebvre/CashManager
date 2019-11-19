package CashManager.Model;

import CashManager.Model.Login;

public class Register extends Login {

    String name;

    String surname;
    public Register(String email, String password, String name, String surname) {
        super(email, password);
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
