package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.Notification;
import itmo.com.overlook.hotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification getNotificationByFromClientId(Integer id);

    @Query("SELECT n FROM Notification n WHERE n.toClientId is null and n.fromClientId is not null")
    List<Notification> findAllAdmin();

    List<Notification> getNotificationsByToClientId(User user);
}
