import { Component, OnInit } from '@angular/core';
import {Hotel} from "../models/hotel";
import {DirectorService} from "../services/director.service";
import {TokenStorageService} from "../services/token-storage.service";
import {RoomConstructorService} from "../services/room-constructor.service";
import {Room} from "../models/room";

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  public currentUser: any;
  public hotel!: Hotel;
  public rooms!: Room[];
  public room!: Room;

  constructor(private directorService: DirectorService,
              private token: TokenStorageService,
              private roomConstructorService: RoomConstructorService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    console.log(this.currentUser);
    //переписать на forkjoin
    this.directorService.getHotel().subscribe(
      (hotel) => {
        this.hotel = hotel;
      }
    )
    this.roomConstructorService.getAllRooms().subscribe(
      (data) => {
        console.log("lalka1");
        this.rooms = data;
        console.log("lalka2");
        console.log(data);
        console.log(this.rooms);
        }
    )
    this.roomConstructorService.getRoomById(2).subscribe(
      (data) => {
        this.room = data;
      }
    )
  }
}
