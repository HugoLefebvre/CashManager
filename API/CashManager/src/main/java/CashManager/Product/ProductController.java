package CashManager.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    ProductDatabase productAction = new ProductDatabase();

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody Product product){
        return productAction.addProduct(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam String id){
        return productAction.removeProduct(id);
    }

    @PutMapping("/product")
    public ResponseEntity updateProduct(@RequestBody Product product, @RequestParam String id){
        return productAction.updateProduct(product, id);
    }
}
