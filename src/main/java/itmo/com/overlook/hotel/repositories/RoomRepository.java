package itmo.com.overlook.hotel.repositories;


import itmo.com.overlook.hotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room getRoomByClientid(Integer id);
}
