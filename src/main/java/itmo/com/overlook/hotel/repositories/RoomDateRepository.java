package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.RoomDate;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomDateRepository extends JpaRepository<RoomDate, Integer>{
/*
    //сюда нужно передавать желаемые даты
    @Query("SELECT r.room FROM RoomDate r WHERE r.date < '2022-11-03' and r.date > '2022-11-01'")
    Room[] getFreeRooms();
*/

    List<RoomDate> getAllByRoomId(Integer id);

/* @Query("DO $$ declare date Date := arrivalDate begin while date <= departureDate loop INSERT INTO public.room_dates(date, room_id) VALUES (date, 1) date := date + 1 end loop end$$")*/

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into room_dates (date, room_id) VALUES (:date,:id)", nativeQuery = true)
    void saveRoomDate(Integer id, Date date);
   /* void saveForEachDate(Integer id, Date arrivalDate, Date departureDate);*/
}
