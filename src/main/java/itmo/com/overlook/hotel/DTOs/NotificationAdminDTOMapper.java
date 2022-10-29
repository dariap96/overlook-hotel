package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.Notification;


import java.time.LocalDate;

public class NotificationAdminDTOMapper {
    public NotificationAdminDTO toDTO (Notification notification) {
        String info = notification.getInfo();
        Integer fromClientID = notification.getFromclientid().getId();
        Integer room = notification.getFromclientid().getRoom().getId();
        String client_name = notification.getFromclientid().getName()+" "+notification.getFromclientid().getSurname();
        Integer room_number = notification.getFromclientid().getRoom().getNumber();
        return new NotificationAdminDTO(info, fromClientID, room, client_name, room_number);
    }
}
