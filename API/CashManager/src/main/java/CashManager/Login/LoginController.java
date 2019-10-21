package CashManager.Login;
import CashManager.Utils.UtilsFunctions;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static CashManager.Utils.UtilsFunctions.bodyToMap;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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