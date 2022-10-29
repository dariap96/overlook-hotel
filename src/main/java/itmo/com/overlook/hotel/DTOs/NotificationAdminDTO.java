package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationAdminDTO {
    private String info;
    private Integer fromClientID;
    private Integer room;

    private String client_name;

    private Integer room_number;

    NotificationAdminDTO(String info, Integer fromClientID, Integer room, String client_name, Integer room_number) {
        this.info = info;
        this.fromClientID = fromClientID;
        this.room = room;
        this.client_name = client_name;
        this.room_number = room_number;

    }
}
