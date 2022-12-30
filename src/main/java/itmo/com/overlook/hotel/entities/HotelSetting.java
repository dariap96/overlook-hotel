package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "settings")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class HotelSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "number")
    private Long number;


    public HotelSetting(Integer id, String monday, String tuesday, String wednesday, String thursday,
                        String friday, String saturday, String sunday, Float rate,
                        Long number) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.rate = rate;
        this.number = number;
    }
}
