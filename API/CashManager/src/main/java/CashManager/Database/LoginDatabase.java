package CashManager.Database;

import CashManager.Model.Register;
import CashManager.Model.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDatabase extends Database {

    public ResponseEntity Login(Login user){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity Register(Register user){

        try
        {
            String query = "SELECT * FROM user where email = '" + user.getEmail() + "'";
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if(rs != null){
                rs.last();
                int size = rs.getRow();
                if(size != 0)
                    return new ResponseEntity<>("ERROR_EMAIL_TAKEN", HttpStatus.UNAUTHORIZED);
            }
            query = "INSERT INTO user (email, password) VALUES (?, ?)";
            PreparedStatement preparedStmt = this.conn.prepareStatement(query);
            preparedStmt.setString (1, user.getEmail());
            preparedStmt.setString (2, user.getPassword());

            preparedStmt.execute();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
