package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToOne(mappedBy = "room", cascade = {CascadeType.ALL})
    private User client;

    /*@OneToMany(mappedBy = "room")
    private Set<RoomDate> roomDates = new HashSet<>();*/

    public Room(Integer id, Integer number, Integer countPeople, Integer stage,
                Double price, boolean status, User client) {
        this.id = id;
        this.number = number;
        this.countPeople = countPeople;
        this.stage = stage;
        this.price = price;
        this.status = status;
        this.client = client;
    }

}
