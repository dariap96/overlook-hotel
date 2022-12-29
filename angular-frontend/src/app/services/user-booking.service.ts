import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client_Notification} from "../models/client_notification";
import {Booking} from "../models/booking";

@Injectable({
  providedIn: 'root'
})
export class UserBookingService {

  constructor(private http: HttpClient) { }

  public getUserBookings(id: number): Observable<Booking[]> {
    return this.http.get<Booking[]>("http://localhost:8080/api/bookings/" + id);
  }
}
