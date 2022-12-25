package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.Notification;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class NotificationDTOMapper {

    private final UserService userService;
    public NotificationAdminDTO toDTO (Notification notification) {
        String info = notification.getInfo();
        Integer fromClientId = notification.getFromClientId().getId();
        Integer room = notification.getFromClientId().getRoom().getId();
        String client_name = notification.getFromClientId().getName()+" "+notification.getFromClientId().getSurname();
        Integer room_number = notification.getFromClientId().getRoom().getNumber();
        return new NotificationAdminDTO(info, fromClientId, room, client_name, room_number);
    }

    public NotificationClientDTO toClientDTO (Notification notification) {
        String info = notification.getInfo();
        Integer toClientId = notification.getToClientId().getId();
        Integer room = notification.getToClientId().getRoom().getId();
        String client_name = notification.getToClientId().getName()+" "+notification.getFromClientId().getSurname();
        Integer room_number = notification.getToClientId().getRoom().getNumber();
        return new NotificationClientDTO(info, toClientId, room, client_name, room_number);
    }

    public Notification toEntity(NotificationDTO notificationDTO){
        String info = notificationDTO.info;
        User fromClientId = userService.getById(notificationDTO.fromClientId);
        User toClientId = userService.getById(notificationDTO.toClientId);
        return new Notification(fromClientId, toClientId, info);
    }
}
