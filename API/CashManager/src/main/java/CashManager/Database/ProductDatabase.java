package CashManager.Database;

import CashManager.Database.Database;
import CashManager.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends Database{

    public ResponseEntity getAllProducts(){
        try
        {
            String query = "SELECT * FROM produit";
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            List<Product> listProducts = new ArrayList<>();
            while (rs.next())
            {
                if(rs.getString("p_code") == null || rs.getString("p_code") == "")
                    return new ResponseEntity<>("ERR_INT", HttpStatus.NOT_FOUND);
                Product product = new Product(rs.getInt("id_produit"), rs.getString("p_code"), rs.getString("nom_produit"), rs.getInt("prix_unit"));
                listProducts.add(product);
            }
            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getProductById(String id){
        try
        {
            String query = "SELECT * FROM produit WHERE id_produit = " + id;
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                if(rs.getString("p_code") == null || rs.getString("p_code") == "")
                    return new ResponseEntity<>("ERR_INT", HttpStatus.NOT_FOUND);
                Product product = new Product(rs.getInt("id_produit"), rs.getString("p_code"), rs.getString("nom_produit"), rs.getInt("prix_unit"));
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            st.close();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity getProductByCode(String code){
        try
        {
            String query = "SELECT * FROM produit WHERE p_code = '" + code + "'";
            Statement st = this.conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                if(rs.getString("p_code") == null || rs.getString("p_code") == "")
                    return new ResponseEntity<>("ERR_INT", HttpStatus.NOT_FOUND);
                Product product = new Product(rs.getInt("id_produit"), rs.getString("p_code"), rs.getString("nom_produit"), rs.getInt("prix_unit"));
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            st.close();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity addProduct(Product product){
        String regex = "\\d+";
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
