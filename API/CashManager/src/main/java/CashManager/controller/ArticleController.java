package CashManager.controller;

import CashManager.model.Article;
import CashManager.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/all")
    List<Article> getAllArticles(){
        return (List<Article>) articleRepository.findAll();
    }

    @GetMapping("/id/{id}")
    Article getArticleById(@PathVariable Integer id){
        return articleRepository.findById(id).get();
    }

    @GetMapping("/code/{code}")
    Article getArticleByCode(@PathVariable String code){
        return articleRepository.getByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Article addArticle(@Valid @RequestBody Article article){
        return articleRepository.save(article);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    String deleteArticle(@PathVariable Integer id){
        articleRepository.deleteById(id);
        return "Successfully deleted";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Article updateArticle(@PathVariable Integer id, @Valid @RequestBody Article article){
        Article update = articleRepository.findById(id).get();
        update.setName(article.getName());
        update.setPrice(article.getPrice());
        update.setCode(article.getCode());
        articleRepository.save(update);
        return update;
    }
}
