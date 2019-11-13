package CashManager.Login;

import CashManager.Database.Database;

public class Login {
    Integer id;
    String email;
    String password;

    public Login(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
