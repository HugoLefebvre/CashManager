package CashManager.controller;

import CashManager.model.Article;
import CashManager.model.User;
import CashManager.repository.ArticleRepository;
import CashManager.repository.UserRepository;
import CashManager.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity login(@Valid @RequestBody User user){
        User dbUser = userRepository.findUserByEmail(user.getEmail());
        if(dbUser != null){
            boolean passwordMatch = PasswordUtils.verifyUserPassword(user.getPassword(), dbUser.getPassword(), dbUser.getSalt());
            if(passwordMatch)
                return new ResponseEntity(dbUser.getId(), HttpStatus.OK);
        }
        return new ResponseEntity("Error : Given email or password are not matching", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity register(@Valid @RequestBody User user){
        User dbUser = userRepository.findUserByEmail(user.getEmail());
        if(dbUser == null){
            String salt = PasswordUtils.getSalt(30);
            user.setSalt(salt);
            user.setPassword(PasswordUtils.generateSecurePassword(user.getPassword(), user.getSalt()));
            userRepository.save(user);
            return new ResponseEntity("Successfully registered", HttpStatus.CREATED);
        } else
            return new ResponseEntity("Error : Email already taken", HttpStatus.UNAUTHORIZED);
    }

}
