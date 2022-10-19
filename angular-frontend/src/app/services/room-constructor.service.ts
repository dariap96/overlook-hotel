import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Room} from "../models/room";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoomConstructorService {

  constructor(private http: HttpClient) { }

  ROOM_URL: string = "http://localhost:4200/" + 'api/student';

  getAllRooms(): Observable<any> {
    return this.http.get<any>(this.ROOM_URL);
  }

  public postRoom(room: Room) {
    return this.http.post(this.ROOM_URL, room);
  }

  public updateRoom(room: Room) {
    return this.http.patch(this.ROOM_URL, room);
  }
}
