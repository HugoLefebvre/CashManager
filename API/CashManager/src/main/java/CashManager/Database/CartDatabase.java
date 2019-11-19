package CashManager.Database;

import CashManager.Model.PushProduct;
import CashManager.Model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartDatabase extends Database {

    public boolean productExists(int idProduct){
        try
        {
            String query = "SELECT * FROM produit where id_user = '" + idProduct + "'";
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if(rs != null){
                rs.last();
                int size = rs.getRow();
                if(size != 0)
                    return true;
            }
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public ResponseEntity getCart(Cart cart){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity addToCart(PushProduct push){
        try
        {
            String query = "SELECT * FROM panier where id_user = '" + push.getIdUser() + "' AND id_produit = '" + push.getIdProduct() + "'";
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if(rs != null){
                rs.last();
                int size = rs.getRow();
                if(size != 0){

                }

            }

            query = "INSERT INTO user (email, password) VALUES (?, ?)";
            PreparedStatement preparedStmt = this.conn.prepareStatement(query);
            //preparedStmt.setString (1, user.getEmail());
            //preparedStmt.setString (2, user.getPassword());

            preparedStmt.execute();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity removeFromCart(PushProduct push){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity updateCart(PushProduct push){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
