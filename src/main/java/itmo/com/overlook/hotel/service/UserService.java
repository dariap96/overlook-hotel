package itmo.com.overlook.hotel.service;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.repositories.RoomRepository;
import itmo.com.overlook.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public User getById(Integer id) {
        log.info("IN User Service getById {}", id);
        return userRepository.findById(id).get();
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
        log.info("IN RoomService getAll");
        return userRepository.findAll();
    }

    public List<User> getAllClients() {
        log.info("IN RoomService getAllClients");
        return userRepository.findAll();
        // здесь нужно будет исправить на ту функцию, которую допишем в UserRepository
    }

    public List<User> getAllAdmins() {
        log.info("IN RoomService getAllAdmins");
        return userRepository.findAll();
        // здесь нужно будет исправить на ту функцию, которую допишем в UserRepository
    }
}
