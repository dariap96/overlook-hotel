package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.repositories.BookingRepository;
import itmo.com.overlook.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;


    public Booking getById(Integer id) {
        log.info("IN Booking Service getById {}", id);
        return bookingRepository.findById(id).get();
    }

    public List<Booking> getAll() {
        log.info("IN Booking Service getAll");
        return bookingRepository.findAll();
    }

    public void save(Booking booking) {
        log.info("IN RoomService save {}", booking.getId());
        bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByClientId(Integer id) {
        User user = this.userRepository.findById(id).get();
        log.info("IN RoomService getByUserId {}", id);
        return bookingRepository.getBookingsByUser(user);
    }
}
