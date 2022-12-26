package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.DTOs.RoomDateDTO;
import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.RoomDate;
import itmo.com.overlook.hotel.services.BookingService;
import itmo.com.overlook.hotel.services.RoomDateService;
import itmo.com.overlook.hotel.services.RoomService;
import itmo.com.overlook.hotel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roomdates")
public class RoomDateController {
    private final RoomDateService roomDateService;
    private final RoomService roomService;
    private final UserService userService;
    private final BookingService bookingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RoomDate>> getRoomDateByRoom(@PathVariable("id") Integer roomId) {
        if (roomId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<RoomDate> roomDates = this.roomDateService.getRoomDateByRoom(roomId);
        return new ResponseEntity<>(roomDates, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addRoomDate(@RequestBody RoomDateDTO roomDateDTO) {
        if (roomDateDTO.getRoomId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Date date = roomDateDTO.getArrivalDate();
        Booking booking = new Booking(roomDateDTO.getArrivalDate(), roomDateDTO.getDepartureDate(), this.userService.getById(roomDateDTO.getUserId()), this.roomService.getById(roomDateDTO.getRoomId()));
        this.bookingService.save(booking);
        while (date.before(roomDateDTO.getDepartureDate()) || date.equals(roomDateDTO.getDepartureDate()) ) {
            this.roomDateService.save(roomDateDTO.getRoomId(), date);
            System.out.println(date);

            Calendar c = Calendar.getInstance();
            c.setTime(date);

            c.add(Calendar.DATE, 1); // то же самое с c.add (Calendar.DAY_OF_MONTH, 1);
            date = c.getTime();

            System.out.println(date);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
