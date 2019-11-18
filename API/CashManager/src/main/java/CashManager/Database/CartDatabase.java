package CashManager.Database;

import CashManager.Model.PushProduct;
import CashManager.Model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CartDatabase {

    public ResponseEntity getCart(Cart cart){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity addToCart(PushProduct push){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity removeFromCart(PushProduct push){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity updateCart(PushProduct push){
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
