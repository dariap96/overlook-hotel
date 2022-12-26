package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Role;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserByEmail(String email);


    @Query( "select u from User u  where u.roleSet in :roles" )
    public List<User> findByRoles(@Param("roles") Set<Role> roles);

    /*@Query("SELECT user FROM users user LEFT JOIN users_roles user_role ON user.id=user_role.user_id LEFT JOIN roles role on user_role.role_id=role.id WHERE roles.role = ")
    List<User> getAllClients();

    @Query("SELECT u FROM User u WHERE u.status = 1")
    List<User> getAllAdmins();*/
   /* здесь я что-то запуталась с ролями, но по идее нужно прописать запрос sql
    чтобы вытащить только админов или только клиентов
    но вообще можно всегда вытаскивать всех, а показывать на фронте только тех что надо))))*/

}
