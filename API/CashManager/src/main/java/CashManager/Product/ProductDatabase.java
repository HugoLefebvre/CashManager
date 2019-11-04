package CashManager.Product;

import CashManager.Database.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.PreparedStatement;

public class ProductDatabase extends Database{

    public ResponseEntity addProduct(Product product){
        String regex = "\\d+";
        System.out.println(product.prix_unit.toString());
        if(product.getpCode() == null || product.getName() == null || product.getPrix_unit() == null)
            return new ResponseEntity<>("ERR_EMPTY", HttpStatus.BAD_REQUEST);
        if(! product.getPrix_unit().toString().matches(regex))
            return new ResponseEntity<>("ERR_INT", HttpStatus.BAD_REQUEST);
        try{
            String query = "INSERT INTO produit (p_code, nom_produit, prix_unit) VALUES (?, ?, ?)";

            PreparedStatement preparedStmt = this.conn.prepareStatement(query);
            preparedStmt.setString (1, product.getpCode());
            preparedStmt.setString (2, product.getName());
            preparedStmt.setString (3, product.getPrix_unit().toString());

            preparedStmt.execute();
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity removeProduct(String id){
        String regex = "\\d+";
        if(id == null)
            return new ResponseEntity<>("ERR_EMPTY", HttpStatus.BAD_REQUEST);
        if(! id.matches(regex))
            return new ResponseEntity<>("ERR_INT", HttpStatus.BAD_REQUEST);
        try{
            String query = "DELETE FROM produit WHERE id_produit = ?";

            PreparedStatement preparedStmt = this.conn.prepareStatement(query);
            preparedStmt.setString (1, id);

            preparedStmt.execute();
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity updateProduct(Product product, String id){
        String regex = "\\d+";
        if(product.getpCode() == null || product.getName() == null || product.getPrix_unit() == null)
            return new ResponseEntity<>("ERR_EMPTY", HttpStatus.BAD_REQUEST);
        if(! product.getPrix_unit().toString().matches(regex))
            return new ResponseEntity<>("ERR_INT", HttpStatus.BAD_REQUEST);
        try{
            String query = "UPDATE produit SET p_code = ?, nom_produit = ?, prix_unit = ? WHERE id_produit = ?";

            PreparedStatement preparedStmt = this.conn.prepareStatement(query);
            preparedStmt.setString (1, product.getpCode());
            preparedStmt.setString (2, product.getName());
            preparedStmt.setString (3, product.getPrix_unit().toString());
            preparedStmt.setString (4, id);

            preparedStmt.execute();
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
