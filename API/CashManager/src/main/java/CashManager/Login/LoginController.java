package CashManager.Login;
import CashManager.Utils.UtilsFunctions;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class LoginController {
    Login loginAction = new Login();

    @PostMapping("/login")
    public String login(@RequestBody String body){
        Map<String, String> bodyMap = UtilsFunctions.bodyToMap(body);

        String username = UtilsFunctions.getValue(bodyMap, "username");
        String password = UtilsFunctions.getValue(bodyMap, "password");

        return loginAction.Login(username, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody String body){
        Map<String, String> bodyMap = UtilsFunctions.bodyToMap(body);

        String username = UtilsFunctions.getValue(bodyMap, "username");
        String password = UtilsFunctions.getValue(bodyMap, "password");

        return loginAction.Register(username, password);
    }
}