package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.HotelSetting;
import itmo.com.overlook.hotel.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class TableDTOMapper {

    public TableDTO toDTO (HotelSetting setting) {
        String monday = setting.getMonday();
        String tuesday = setting.getTuesday();
        String wednesday = setting.getWednesday();
        String thursday = setting.getThursday();
        String friday = setting.getFriday();
        String saturday = setting.getSaturday();
        String sunday = setting.getSunday();
        return new TableDTO(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }
}
