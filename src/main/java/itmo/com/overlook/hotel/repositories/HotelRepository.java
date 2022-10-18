package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    Hotel getFirst();
}
