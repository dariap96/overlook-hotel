import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Room} from "../models/room";
import {Observable} from "rxjs";

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

  public postRoom(id: number) {
    return this.http.post(this.ROOM_URL+id, {});
  }

  public updateRoom(id: number) {
    return this.http.patch(this.ROOM_URL+id, {});
  }
}
