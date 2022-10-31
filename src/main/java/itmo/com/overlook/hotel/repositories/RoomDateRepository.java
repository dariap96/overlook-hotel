package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.RoomDate;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDateRepository extends JpaRepository<RoomDate, Integer>{
    //сюда нужно передавать желаемые даты
    @Query("SELECT r.room FROM RoomDate r WHERE r.date < '2022-11-03' and r.date > '2022-11-01'")
    Room[] getFreeRooms();

    List<RoomDate> getAllByRoomId(Integer id);
}
