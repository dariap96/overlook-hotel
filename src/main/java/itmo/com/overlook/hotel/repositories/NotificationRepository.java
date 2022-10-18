package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification getNotificationByFromclientid(Integer id);
}
