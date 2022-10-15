package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login"),
                @UniqueConstraint(columnNames = "email")
        })
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    @Size(max = 20)
    private String name;

    @Column(name = "surname")
    @Size(max = 20)
    private String surname;

    @Column(name = "bday")
    private LocalDate bday;

    @Column(name = "login", nullable = false)
    @Size(max = 20)
    private String login;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 20)
    private String password;

    @Column(name = "email", nullable = false)
    @Size(max = 20)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {

    }
}
