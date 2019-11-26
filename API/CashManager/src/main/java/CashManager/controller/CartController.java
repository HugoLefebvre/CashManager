package CashManager.controller;

import CashManager.model.Article;
import CashManager.model.Cart;
import CashManager.model.User;
import CashManager.repository.ArticleRepository;
import CashManager.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/user/{id}")
    List<Article> getCartByUserId(@PathVariable Integer id){
        List<Cart> idArticleList = cartRepository.getByIdUser(id);
        List<Article> articleList = new ArrayList<>();
        if(idArticleList != null){
            for(Cart cart : idArticleList) {
                articleList.add(articleRepository.findById(cart.getIdArticle()).get());
            }
        }
        return articleList;
    }

    @GetMapping("/user/{id}/total")
    Integer getUserTotalCart(@PathVariable Integer id){
        Integer sum = 0;
        List<Cart> idArticleList = cartRepository.getByIdUser(id);
        List<Article> articleList = new ArrayList<>();
        if(idArticleList != null){
            for(Cart cart : idArticleList) {
                articleList.add(articleRepository.findById(cart.getIdArticle()).get());
            }
            for(Article article : articleList){
                sum += article.getPrice();
            }
        }
        return sum;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Cart addToCart(@Valid @RequestBody Cart cart){
        cartRepository.save(cart);
        return cart;
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity deleteFromCart(@PathVariable Integer id){
        cartRepository.deleteAllByIdUser(id);
        return new ResponseEntity("Successfully deleted", HttpStatus.OK);
    }

    @DeleteMapping("/user/{iduser}/article/{idarticle}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity deleteArticleFromCart(@PathVariable Integer iduser, @PathVariable Integer idarticle){
        cartRepository.deleteByIdArticleAndIdUser(idarticle, iduser);
        return new ResponseEntity("Successfully deleted", HttpStatus.OK);
    }

}