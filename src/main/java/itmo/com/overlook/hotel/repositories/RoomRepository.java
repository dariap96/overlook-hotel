package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room getRoomByClient(User user);

    @Query(value = "SELECT r FROM rooms r WHERE r.status = 'vip'",   nativeQuery = true)
    Room[] getVipRooms(Room[] rooms);
    //не работаееЕЕЕт
}
