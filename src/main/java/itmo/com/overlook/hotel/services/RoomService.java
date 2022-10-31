package itmo.com.overlook.hotel.services;

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
public class RoomService {
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public Room getById(Integer id) {
        log.info("IN Room Service getById {}", id);
        return roomRepository.findById(id).get();
    }

    public void save(Room room) {
        log.info("IN RoomService save {}", room);
        roomRepository.save(room);
    }

    public void delete(Integer id) {
        log.info("IN RoomService delete {}", id);
        roomRepository.deleteById(id);
    }

    public List<Room> getAll() {
        log.info("IN RoomService getAll");
        return roomRepository.findAll();
    }

    public Room getRoomByClientId(Integer id) {
        User user = this.userRepository.findById(id).get();
        log.info("IN RoomService getByUserId {}", id);
        return roomRepository.getRoomByClient(user);
    }
    public Room[] getVipRooms() {
        return roomRepository.getVipRooms();
    }
    //не работает не работает))()(
}
