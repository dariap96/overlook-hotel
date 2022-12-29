package itmo.com.overlook.hotel.DTOs;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TableDTO {
    private String monday;

    private String tuesday;

    private String wednesday;

    private String thursday;

    private String friday;

    private String saturday;

    private String sunday;

    public TableDTO(String monday, String tuesday, String wednesday, String thursday,
                       String friday, String saturday, String sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }
}
