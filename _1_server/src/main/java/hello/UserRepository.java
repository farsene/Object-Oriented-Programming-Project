package hello;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User repository extending to crud repository.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Query to findAllUsers.
     */
    @Query(value = "SELECT * from users", nativeQuery = true)
   List<User> findAllUsers();
    /**
     * Query to find a specific user by username.
     * @param username
     */
    @Query(value = "SELECT * from users where username = ?1",
            nativeQuery = true)
    List<User> findUserByUsername(@Param("username") String username);
    /**
     * Query to update a users attributes.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET foodFootprint = ?1 WHERE username = ?2",
            nativeQuery = true)
    void updateActivity(Integer food, String username);
}
