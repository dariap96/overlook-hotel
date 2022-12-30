import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Booking} from "../models/booking";
import {RoomDate} from "../models/roomDate";

@Injectable({
  providedIn: 'root'
})
export class UserBookingService {

  constructor(private http: HttpClient) { }

  public getUserBookings(id: number): Observable<Booking[]> {
    return this.http.get<Booking[]>("http://localhost:8080/api/bookings/" + id);
  }

  public createBooking(roomDate: RoomDate, id: number | undefined): Observable<RoomDate> {
    return this.http.post<RoomDate>("http://localhost:8080/api/roomdates", roomDate);
  }
}
