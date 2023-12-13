import { Component, OnInit } from '@angular/core';
import {Hotel} from "../models/hotel";
import {DirectorService} from "../services/director.service";
import {TokenStorageService} from "../services/token-storage.service";
import {RoomConstructorService} from "../services/room-constructor.service";
import {Room} from "../models/room";
import {UserService} from "../services/user.service";
import {User} from "../models/user";

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  public currentUser: User;
  public hotel!: Hotel;
  public rooms!: Room[];
  public vipRooms: Room[];

  constructor(private directorService: DirectorService,
              private token: TokenStorageService,
              private roomConstructorService: RoomConstructorService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUser(this.token.getUser().id).subscribe(
      (user) => {
        this.currentUser = user;
      }
    );
    console.log(this.currentUser);
    //переписать на forkjoin
    this.directorService.getHotel().subscribe(
      (hotel) => {
        this.hotel = hotel;
      }
    )
    this.roomConstructorService.getAllRooms().subscribe(
      (data) => {
        this.rooms = data;
        }
    )
    this.roomConstructorService.getVipRooms().subscribe(
      (data) => {
        this.vipRooms = data;
      }
    )

  }

}
