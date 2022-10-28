import { Component, OnInit } from '@angular/core';
import {Room} from "../models/room";
import {RoomConstructorService} from "../services/room-constructor.service";

@Component({
  selector: 'app-room-constructor',
  templateUrl: './room-constructor.component.html',
  styleUrls: ['./room-constructor.component.css']
})
export class RoomConstructorComponent implements OnInit {

  public rooms!: Array<Room>;
  public room!: Room;

  constructor(private roomConstructorService: RoomConstructorService) {
  }

  ngOnInit(): void {
    this.roomConstructorService.getAllRooms().subscribe(data => {
      this.rooms = data;
    });
  }

  postRoom() {
    this.roomConstructorService.postRoom(this.room.id).subscribe(
      () => console.log('Posting correctly'),
      error => console.warn(error)
    )
    window.location.reload();
  }

  updateRoom() {
    this.roomConstructorService.updateRoom(this.room.id).subscribe(
      () => console.log('Updating correctly'),
      error => console.warn(error)
    )
    window.location.reload();
  }



}
