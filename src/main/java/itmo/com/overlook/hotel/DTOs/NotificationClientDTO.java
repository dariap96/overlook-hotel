package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

@Data
public class NotificationClientDTO {
    private String info;
    private Integer toClientId;
    private Integer room;

    private String client_name;

    private Integer room_number;

    NotificationClientDTO(String info, Integer toClientId, Integer room, String client_name, Integer room_number) {
        this.info = info;
        this.toClientId = toClientId;
        this.room = room;
        this.client_name = client_name;
        this.room_number = room_number;

    }
}
