package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.ERole;
import itmo.com.overlook.hotel.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(ERole role);
}
