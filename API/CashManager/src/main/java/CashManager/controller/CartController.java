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

    @GetMapping("/getUserCart/{id}")
    List<Article> getCartByUserId(@PathVariable Integer id){
        List<Integer> idArticleList = cartRepository.getUserCart(id);
        List<Article> articleList = new ArrayList<>();
        if(idArticleList != null){
            for(Integer idArticle : idArticleList) {
                articleList.add(articleRepository.findById(idArticle).get());
            }
        }
        return articleList;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Cart addToCart(@Valid @RequestBody Cart cart){
        cartRepository.save(cart);
        return cart;
    }



}