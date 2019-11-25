package CashManager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import CashManager.model.Article;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    @Query(value = "SELECT * FROM article where code = :code LIMIT 1", nativeQuery = true)
    Article findArticleByCode(@Param("code") String code);

}
