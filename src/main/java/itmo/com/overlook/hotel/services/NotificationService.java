package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Notification;
import itmo.com.overlook.hotel.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

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
        return notificationRepository.getNotificationByFromclientid(id);
    }
}
