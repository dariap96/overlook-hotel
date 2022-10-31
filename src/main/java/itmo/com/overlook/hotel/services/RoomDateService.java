package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.RoomDate;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.repositories.RoomDateRepository;
import itmo.com.overlook.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomDateService {
    private final RoomDateRepository roomDateRepository;
    private final RoomRepository roomRepository;

    public List<RoomDate> getRoomDateByRoom(Integer id) {
        Room room = this.roomRepository.findById(id).get();
        log.info("IN RoomDateService getRoomDateByRoom {}", id);
        return roomDateRepository.getAllByRoomId(id);
    }


}
