package CashManager.Model;

import CashManager.Service.LoginService;

public class Login implements LoginService {
    String email;
    String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
