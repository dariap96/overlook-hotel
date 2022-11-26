package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationAdminDTO {
    private String info;
    private Integer fromClientId;
    private Integer room;

    private String client_name;

    private Integer room_number;

    NotificationAdminDTO(String info, Integer fromClientId, Integer room, String client_name, Integer room_number) {
        this.info = info;
        this.fromClientId = fromClientId;
        this.room = room;
        this.client_name = client_name;
        this.room_number = room_number;

    }
}
