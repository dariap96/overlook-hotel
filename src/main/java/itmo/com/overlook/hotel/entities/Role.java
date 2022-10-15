package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "roles")
@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany(mappedBy = "roleSet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> userSet = new HashSet<>();

    public Role(ERole role) {
        this.role = role;
    }

    public Role() {
    }
}
