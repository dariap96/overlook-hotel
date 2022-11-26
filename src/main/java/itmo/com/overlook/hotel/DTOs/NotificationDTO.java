package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

@Data
public class NotificationDTO {

    protected String info;
    protected Integer fromClientId;
    protected Integer toClientId;

    NotificationDTO(String info, Integer fromClientID, Integer toClientID) {
        this.info = info;
        this.fromClientId = fromClientID;
        this.toClientId = toClientID;
    }
}
