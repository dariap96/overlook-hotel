package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.DTOs.UserDTO;
import itmo.com.overlook.hotel.DTOs.UserDTOMapper;
import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/users")
public class UserController {

   /* private final ClientService clientService;
    private final AdminService adminService;
    private final DirectorService directorService;

    public UserController(ClientService clientService, AdminService adminService, DirectorService directorService){
        this.clientService = clientService;
        this.adminService = adminService;
        this.directorService = directorService;
    }

    @GetMapping
    public void index(){

    }*/

    private final UserService userService;

    private final UserDTOMapper userDtoMapper = new UserDTOMapper();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = this.userService.getById(id);
        System.out.println(user);

        return new ResponseEntity<>(this.userDtoMapper.toDTO(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/director", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDTO> getDirector() {

        User user = this.userService.getDirector();

        return new ResponseEntity<UserDTO>(this.userDtoMapper.toDTO(user), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = this.userService.getAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User i: users) {
            userDTOs.add(this.userDtoMapper.toDTO(i));
        }

        return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //добавить метода для вытаскивания всех clients и админов
}
