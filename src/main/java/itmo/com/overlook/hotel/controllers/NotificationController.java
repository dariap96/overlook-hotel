package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.DTOs.NotificationAdminDTO;
import itmo.com.overlook.hotel.DTOs.NotificationDTO;
import itmo.com.overlook.hotel.DTOs.NotificationDTOMapper;
import itmo.com.overlook.hotel.entities.Notification;
import itmo.com.overlook.hotel.services.NotificationService;
import itmo.com.overlook.hotel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationDTOMapper notificationDTOMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notification> getNotificationById(@PathVariable("id") Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Notification notification = this.notificationService.getById(id);

        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notification) {
        HttpHeaders headers = new HttpHeaders();
        if (notification == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.notificationService.save(notificationDTOMapper.toEntity(notification));
        return new ResponseEntity<>(notification, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = this.notificationService.getAll();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<NotificationAdminDTO>> getAllAdminNotifications() {
        HttpHeaders headers = new HttpHeaders();
        List<Notification> notifications = this.notificationService.getAllAdmin();
        List<NotificationAdminDTO> notificationAdminDTOS = new ArrayList<NotificationAdminDTO>();
        for (Notification i: notifications) {
            notificationAdminDTOS.add(this.notificationDTOMapper.toDTO(i));
        }
        return new ResponseEntity<>(notificationAdminDTOS, headers, HttpStatus.OK);
    }


}
