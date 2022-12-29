package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.DTOs.TableDTO;
import itmo.com.overlook.hotel.DTOs.TableDTOMapper;
import itmo.com.overlook.hotel.entities.Hotel;
import itmo.com.overlook.hotel.entities.HotelSetting;
import itmo.com.overlook.hotel.services.HotelService;
import itmo.com.overlook.hotel.services.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final SettingsService settingsService;

    private final TableDTOMapper tableDTOMapper;

    @RequestMapping(value = "/rate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Float> getRate() {

        Float rate = this.settingsService.getRate();

        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TableDTO> getTable() {

        TableDTO table = tableDTOMapper.toDTO(this.settingsService.getSetting());

        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    @RequestMapping(value = "/rate", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HotelSetting> updateRate(@RequestBody String rate) {
        HttpHeaders headers = new HttpHeaders();
        if (rate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.settingsService.updateRate(Integer.parseInt(rate));
        return new ResponseEntity<>(this.settingsService.getSetting(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/table", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HotelSetting> updateTable(@RequestBody TableDTO table) {
        HttpHeaders headers = new HttpHeaders();
        if (table == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.settingsService.updateTable(table);
        return new ResponseEntity<>(this.settingsService.getSetting(), headers, HttpStatus.OK);
    }

}
