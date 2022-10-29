package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification getNotificationByFromclientid(Integer id);

    @Query("SELECT n FROM Notification n WHERE n.toclientid is null")
    List<Notification> findAllAdmin();
}
