package itmo.com.overlook.hotel.controllers;


import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.services.HotelService;
import lombok.RequiredArgsConstructor;
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

}
