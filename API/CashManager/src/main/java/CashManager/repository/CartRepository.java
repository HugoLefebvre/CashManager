package CashManager.repository;

import CashManager.model.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;


public interface CartRepository extends CrudRepository<Cart, Integer> {

    ArrayList<Cart> getByIdUser(Integer idUser);
    @Transactional
    void deleteByIdArticleAndIdUser(Integer idarticle, Integer idUser);
    @Transactional
    void deleteAllByIdUser(Integer id);
}

