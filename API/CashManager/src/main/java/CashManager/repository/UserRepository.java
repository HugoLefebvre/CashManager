package CashManager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import CashManager.model.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM user where email = :email LIMIT 1", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);
}
