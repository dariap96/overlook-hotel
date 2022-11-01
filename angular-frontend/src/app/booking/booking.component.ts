import { Component, OnInit } from '@angular/core';
import {Room} from "../models/room";
import {RoomConstructorService} from "../services/room-constructor.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  constructor(private roomConstructorService: RoomConstructorService) { }

  rooms: Room[];

  ngOnInit(): void {
    this.roomConstructorService.getAllRooms().subscribe(
      (data) => {
        this.rooms = data;
        console.log(this.rooms);
      }
    )

  }

}
