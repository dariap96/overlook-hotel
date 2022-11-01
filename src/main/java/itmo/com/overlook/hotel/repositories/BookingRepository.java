package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> getBookingByUser(User user);
}
