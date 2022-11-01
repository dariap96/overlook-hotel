import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Room} from "../models/room";
import {Observable} from "rxjs";
import {Hotel} from "../models/hotel";

@Injectable({
  providedIn: 'root'
})
export class RoomConstructorService {

  constructor(private http: HttpClient) { }

  ROOM_URL: string = "http://localhost:8080/api/rooms";

  public getAllRooms(): Observable<Room[]> {
    return this.http.get<Room[]>("http://localhost:8080/api/rooms");
  }
  public getRoomById(id: number): Observable<Room> {
    return this.http.get<Room>("http://localhost:8080/api/rooms/room/"+id);
  }

  public postRoom(room: Room) {
    return this.http.post(this.ROOM_URL, room);
  }

  public updateRoom(room: Room) {
    return this.http.patch(this.ROOM_URL, room);
  }

  public deleteRoom(room: Room) {
    return this.http.delete("http://localhost:8080/api/rooms/"+room.id);
  }

  public getHotel(): Observable<Hotel> {
    return this.http.get<Hotel>("http://localhost:8080/api/hotel");
  }

  public updateHotel(hotel: Hotel) {
    return this.http.patch("http://localhost:8080/api/hotel", hotel);
  }

  public getVipRooms(): Observable<Room[]>{
    return this.http.get<Room[]>("http://localhost:8080/api/rooms/vip");
  }

}
