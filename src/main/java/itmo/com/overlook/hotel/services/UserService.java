package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.ERole;
import itmo.com.overlook.hotel.entities.Role;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.repositories.RoleRepository;
import itmo.com.overlook.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User getById(Integer id) {
        if (id != null) {
            log.info("IN UserService getById {}", id);
            return userRepository.findById(id).get();
        }
        log.info("IN UserService getById {} returned null", id);
        return null;
    }

    public void save(User user) {
        log.info("IN UserService save {}", user);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        log.info("IN UserService delete {}", id);
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        log.info("IN UserService getAll");
        return userRepository.findAll();
    }

    public User getDirector() {
        log.info("IN UserService getDirector");
        Optional<Role> role =  roleRepository.getByRole(ERole.DIRECTOR);
        return  (User) role.get().getUserSet().toArray()[0];
    }

    public List<User> getAllClients() {
        log.info("IN UserService getAllClients");
        return userRepository.findAll();
        // здесь нужно будет исправить на ту функцию, которую допишем в UserRepository
    }

    public List<User> getAllAdmins() {
        log.info("IN UserService getAllAdmins");
        return userRepository.findAll();
        // здесь нужно будет исправить на ту функцию, которую допишем в UserRepository
    }
}
