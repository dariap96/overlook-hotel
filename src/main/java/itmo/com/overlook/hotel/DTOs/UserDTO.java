package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private String login;
    private String email;
    private LocalDate bday;

    UserDTO(String name, String surname, String login, String email, LocalDate bday) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.bday = bday;
    }
}
