package itmo.com.overlook.hotel.controllers;


import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private final HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hotel> getHotel() {

        Hotel hotel = this.hotelService.getHotel(1);

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        HttpHeaders headers = new HttpHeaders();
        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.hotelService.save(hotel);
        return new ResponseEntity<>(hotel, headers, HttpStatus.OK);
    }

}
