package group.helixlab.spring_demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

    @Query( value = "SELECT u FROM User u WHERE u.enabled = :enabled")
    Iterable<User> getEnabledUser(@Param("enabled") boolean enabled);

    @Query (value = "SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
    User checkUsernamePass(@Param("userName") String username, @Param("password") String password);
}
