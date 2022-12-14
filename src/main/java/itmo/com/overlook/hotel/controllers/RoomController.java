package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.services.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Room room = this.roomService.getById(id);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = this.roomService.getAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

//   судя по внешнему виду не работает ))) но скорее всего оно нам и не нужно
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Room> getRoomByClientid(@PathVariable("id") Integer clientId) {
//        Integer roomId = this.roomService.getRoomByClientId(clientId).getId();
//        if (clientId == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Room room = this.roomService.getById(roomId);
//        return new ResponseEntity<>(room, HttpStatus.OK);
//    }

   /* @RequestMapping(value = "{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> saveRoom(@PathVariable("id") Integer id, @RequestBody Room room) {
        HttpHeaders headers = new HttpHeaders();

        this.roomService.save(room);
        return new ResponseEntity<>(room, headers, HttpStatus.CREATED);
    }*/

    @RequestMapping(value = "", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        HttpHeaders headers = new HttpHeaders();
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.roomService.save(room);
        return new ResponseEntity<>(room, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        HttpHeaders headers = new HttpHeaders();
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.roomService.save(room);
        return new ResponseEntity<>(room, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Integer id) {
        this.roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   @RequestMapping(value = "/vip", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room[]> getVipRooms() {
        Room[] vipRooms = this.roomService.getVipRooms();
       return new ResponseEntity<>(vipRooms, HttpStatus.OK);
   }
}
