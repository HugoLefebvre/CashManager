package CashManager.Controller;

import CashManager.Model.Cart;
import CashManager.Database.CartDatabase;
import CashManager.Model.Product;
import CashManager.Model.PushProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CartController {

    CartDatabase cartAction = new CartDatabase();

    @GetMapping("/cart")
    public ResponseEntity getAllProducts(@RequestBody Cart cart){
        return cartAction.getCart(cart);
    }

    @PostMapping("/cart")
    public ResponseEntity addProduct(@RequestBody PushProduct product){
        return cartAction.addToCart(product);
    }

    @DeleteMapping("/cart")
    public ResponseEntity deleteProduct(@RequestBody PushProduct id){
        return cartAction.removeFromCart(id);
    }

    @PutMapping("/cart")
    public ResponseEntity updateProduct(@RequestBody PushProduct product){
        return cartAction.updateCart(product);

    }
}
