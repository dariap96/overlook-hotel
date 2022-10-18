package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public Hotel getHotel() {
        log.info("IN Room Service getHotel");
        return hotelRepository.getFirst();
    }
}
