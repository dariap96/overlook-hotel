package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.User;
import java.time.LocalDate;

public class UserDTOMapper {
    public UserDTO toDTO (User user) {
        Integer id = user.getId();
        String name = user.getName();
        String surname = user.getSurname();
        String login = user.getLogin();
        String email = user.getEmail();
        LocalDate bday = user.getBday();
        Integer roomNumber = null;
        if (user.getRoom() != null) {
            roomNumber = user.getRoom().getNumber();
        }
        return new UserDTO(id, name, surname, login, email, bday, roomNumber);
    }
}
