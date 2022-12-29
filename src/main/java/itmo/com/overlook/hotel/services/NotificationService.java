package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.entities.Notification;
import itmo.com.overlook.hotel.repositories.BookingRepository;
import itmo.com.overlook.hotel.repositories.NotificationRepository;
import itmo.com.overlook.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    private final BookingRepository bookingRepository;

    public Notification getById(Integer id) {
        log.info("IN Notification Service getById {}", id);
        return notificationRepository.findById(id).get();
    }

    public void save(Notification notification) {
        log.info("IN NotificationService save {}", notification);
        notificationRepository.save(notification);
    }

    public void delete(Integer id) {
        log.info("IN Notification Service delete {}", id);
        notificationRepository.deleteById(id);
    }

    public List<Notification> getAll() {
        log.info("IN NotificationService getAll");
        return notificationRepository.findAll();
    }

    public List<Notification> getAllAdmin() {
        log.info("IN NotificationService getAllAdmin");
        return notificationRepository.findAllAdmin();
    }

    public Notification getNotificationByFromclientid(Integer id) {
        log.info("IN RoomService getAll");
        return notificationRepository.getNotificationByFromClientId(id);
    }

    public List<Notification> getAllClient(Integer id) {
        log.info("IN NotificationService getAllClient");
        if (userRepository.findById(id).get().getRoom() != null) {
            createClientNotification(id);
        }
        return notificationRepository.getAllByToClientId(id);
    }

    public void createClientNotification(Integer id){
        List<Booking> bookings = bookingRepository.getBookingsByUser(userRepository.findById(id).get());
        Date departureDate = bookings.get(bookings.size()-1).getDepartureDate();
        Date now = new Date();
        Date value = new Date(0, 0, 3);
        if (departureDate.getTime() - now.getTime() < value.getTime()) {
            Timestamp numDays = new Timestamp(departureDate.getTime() - now.getTime());
            String text = "Your booking closed in " + numDays + ". It will be " + departureDate.toString();
            Notification notification = new Notification(null, userRepository.findById(id).get(), text);
            notificationRepository.save(notification);
        }
    }
}
