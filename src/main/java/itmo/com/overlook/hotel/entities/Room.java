package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "count_people")
    private Integer countPeople;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "price")
    private Double price;

    @Column(name="available")
    private boolean available;

    @NotNull
    @Column(name = "status", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String status;

    @OneToOne(mappedBy = "room", cascade = {CascadeType.ALL})
    private User client;

    /*@OneToMany(mappedBy = "room")
    private Set<RoomDate> roomDates = new HashSet<>();*/

    public Room(Integer id, Integer number, Integer countPeople, Integer stage,
                Double price, String status, User client, boolean available) {
        this.id = id;
        this.number = number;
        this.countPeople = countPeople;
        this.stage = stage;
        this.price = price;
        this.status = status;
        this.client = client;
        this.available = available;
    }

}
