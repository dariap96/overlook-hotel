package itmo.com.overlook.hotel.service;


import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomService {
    private final RoomRepository roomRepository;

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

    public Room getRoomByClientid(Integer id) {
        log.info("IN RoomService getByUserId {}", id);
        return roomRepository.getRoomByClientid(id);
    }
}
