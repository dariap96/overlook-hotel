package itmo.com.overlook.hotel.DTOs;

import itmo.com.overlook.hotel.entities.User;
import java.time.LocalDate;

public class UserDTOMapper {
    public UserDTO toDTO (User user) {
        String name = user.getName();
        String surname = user.getSurname();
        String login = user.getLogin();
        String email = user.getEmail();
        LocalDate bday = user.getBday();
        Integer roomNumber = user.getRoom().getNumber();
        return new UserDTO(name, surname, login, email, bday, roomNumber);
    }
}
