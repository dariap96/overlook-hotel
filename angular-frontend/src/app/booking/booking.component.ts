import {Component, ElementRef, OnInit} from '@angular/core';
import {Room} from "../models/room";
import {RoomConstructorService} from "../services/room-constructor.service";
import {RoomDate} from "../models/roomDate";
import {User} from "../models/user";
import {FormGroup, FormControl, ɵTypedOrUntyped, ɵFormGroupValue} from "@angular/forms";
import {UserService} from "../services/user.service";
import {TokenStorageService} from "../services/token-storage.service";
import {UserBookingService} from "../services/user-booking.service";
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  constructor(private roomConstructorService: RoomConstructorService,
              private userService: UserService,
              private token: TokenStorageService,
              private bookingService: UserBookingService) { }
  rooms: Room[];
  disabledDates: Date[];
  show = false;
  selectedRoom: Room;
  currentRoom?: Room;
  currentUser: User;
  range = new FormGroup({
    start: new FormControl<Date | null>(null),
    end: new FormControl<Date | null>(null),
  });

  ngOnInit(): void {
    this.userService.getUser(this.token.getUser().id).subscribe(
      (user) => {
        this.currentUser = user;
      }
    );
    this.roomConstructorService.getAllRooms().subscribe(
      (data) => {
        this.rooms = data;
        this.rooms[0].img = "https://media-cdn.tripadvisor.com/media/photo-s/25/fb/99/23/one-bedroom-deluxe-suite.jpg";
        this.rooms[1].img = "https://bali365.info/wp-content/uploads/2018/03/3-1-deluxe-room-1king-bed-ocean-view.jpg";
        console.log(this.rooms);
      }
    )
  }

  showDatepicker(room: Room) {
    room.readyToBeBooked = true;
    this.currentRoom = room;
  }
  padTo2Digits(num?: number) {
    return num?.toString()?.padStart(2, '0');
  }

  bookRoom(room: Room) {
    let startDate = [this.range.value.start?.getFullYear(),
      this.padTo2Digits(this.range.value.start?.getMonth().valueOf() ? this.range.value.start?.getMonth().valueOf() + 1 : 0 ),
      this.padTo2Digits(this.range.value.start?.getDate())].join('-');

    let endDate = [this.range.value.end?.getFullYear(),
      this.padTo2Digits(this.range.value.end?.getMonth().valueOf() ? this.range.value.end?.getMonth().valueOf() + 1 : 0),
      this.padTo2Digits(this.range.value.end?.getDate())].join('-');

    let roomDate: RoomDate = {
      roomId: this.currentRoom?.id,
      userId: this.currentUser.id,
      arrivalDate: startDate,
      departureDate: endDate
    }
    this.bookingService.createBooking(roomDate, roomDate.roomId).subscribe(data => console.log());
    room.readyToBeBooked = false;
    this.currentRoom = undefined;
  }
}
