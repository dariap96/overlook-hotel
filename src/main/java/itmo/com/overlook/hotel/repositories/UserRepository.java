package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Role;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserByEmail(String email);


}
