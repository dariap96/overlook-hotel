package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.entities.RoomDate;
import itmo.com.overlook.hotel.services.RoomDateService;
import itmo.com.overlook.hotel.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roomdates")
public class RoomDateController {
    private final RoomDateService roomDateService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RoomDate>> getRoomDateByRoom(@PathVariable("id") Integer roomId) {
        if (roomId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<RoomDate> roomDates = this.roomDateService.getRoomDateByRoom(roomId);
        return new ResponseEntity<>(roomDates, HttpStatus.OK);
    }
}
