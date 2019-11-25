package CashManager.repository;

import CashManager.model.Article;
import CashManager.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Query(value = "SELECT id_article FROM cart where id_user = :iduser", nativeQuery = true)
    List<Integer> getUserCart(@Param("iduser") Integer iduser);

    @Query(value = "SELECT * from FROM article where id = :idArticle", nativeQuery = true)
    Article getArticle(@Param("idArticle") Integer idArticle);
}

