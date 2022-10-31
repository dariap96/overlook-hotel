package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.entities.RoomDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DateRepository {
    @Repository
    public interface HotelRepository extends JpaRepository<RoomDate, Integer> {
    }
}
