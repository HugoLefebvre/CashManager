package CashManager.Controller;
import CashManager.Model.Login;
import CashManager.Database.LoginDatabase;
import CashManager.Model.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    LoginDatabase loginAction = new LoginDatabase();

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login user){
        return loginAction.Login(user);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Register user){
        return loginAction.Register(user);
    }
}