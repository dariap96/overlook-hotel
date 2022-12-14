package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.entities.Room;
import itmo.com.overlook.hotel.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Booking>> getBookingById(@PathVariable("id") Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Booking> booking = this.bookingService.getByUserId(id);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> booking = this.bookingService.getAll();
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Booking>> getBookingsByClientid(@PathVariable("id") Integer clientId) {
        List<Booking> bookings = this.bookingService.getBookingsByClientId(clientId);
        if (clientId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
