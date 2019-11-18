package CashManager.Controller;

import CashManager.Model.Product;
import CashManager.Database.ProductDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    ProductDatabase productAction = new ProductDatabase();

    @GetMapping("/product/all")
    public ResponseEntity getAllProducts(){
        return productAction.getAllProducts();
    }

    @GetMapping("/product/id")
    public ResponseEntity getProductById(@RequestParam String id){
        return productAction.getProductById(id);
    }

    @GetMapping("/product/code")
    public ResponseEntity getProductByCode(@RequestParam String code){
        return productAction.getProductByCode(code);
    }

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
