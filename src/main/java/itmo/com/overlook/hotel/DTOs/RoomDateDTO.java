package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.Booking;
import lombok.Data;

import java.util.Date;

@Data
public class RoomDateDTO {
    private Integer roomId;
    private Date arrivalDate;
    private Date departureDate;
    private Integer userId;

    RoomDateDTO(Integer roomId, Date arrivalDate, Date departureDate, Integer userId){
        this.roomId = roomId;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.userId = userId;
    }

    /*public Booking toBooking(){
        return new Booking(this.getArrivalDate(), this.getDepartureDate(), this.getRoomId(), this.getUserId());
    }*/

}
