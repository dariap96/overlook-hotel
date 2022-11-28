package itmo.com.overlook.hotel.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 20)
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    private String name;
    private String surname;

    private Set<String> role;
}
