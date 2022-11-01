import { Component, OnInit } from '@angular/core';
import {Room} from "../models/room";
import {RoomConstructorService} from "../services/room-constructor.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css', './hystmodal.min.css']
})
export class BookingComponent implements OnInit {

  constructor(private roomConstructorService: RoomConstructorService) { }

  rooms: Room[];
  disabledDates: Date[];
  show = false;
  selectedRoom: Room;

  ngOnInit(): void {
    this.roomConstructorService.getAllRooms().subscribe(
      (data) => {
        this.rooms = data;
        console.log(this.rooms);
        this.setupDatePickers();
      }
    )

  }

  showPopUp() {
    this.show = true;
    console.log(this.show)
  }

  closePopUp() {
    this.show = false
  }

  closePopUpOverlay(e: any) {
    if (e.target.classList.contains('overlay')) {
      this.show = false;
    }
  }

  saveSelectedRoom(room: Room) {
    this.selectedRoom = room;
  }

  bookRoom() {
    // console.log($("#datepicker1").val())
  }

  setupDatePickers() {
    // $("#datepicker1").datepicker({
    //   minDate: 0,
    //   beforeShowDay: this.disableDates
    // });
    // $("#datepicker2").datepicker({
    //   minDate: 0,
    //   beforeShowDay: this.disableDates
    // });
  }
}
