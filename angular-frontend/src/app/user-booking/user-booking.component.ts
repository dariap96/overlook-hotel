import { Component, OnInit } from '@angular/core';
import {Client_NotificationsService} from "../services/client_notification.service";
import {UserService} from "../services/user.service";
import {TokenStorageService} from "../services/token-storage.service";
import {UserBookingService} from "../services/user-booking.service";
import {Client_Notification} from "../models/client_notification";
import {User} from "../models/user";
import {Booking} from "../models/booking";

@Component({
  selector: 'app-user-booking',
  templateUrl: './user-booking.component.html',
  styleUrls: ['./user-booking.component.css']
})
export class UserBookingComponent implements OnInit {

  public bookings!: Array<Booking>;
  public currentUser: User;

  constructor(private userBookingService: UserBookingService,
              private userService: UserService,
              private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userService.getUser(this.currentUser.id).subscribe(
      data=> {
        this.currentUser = data;
        console.log(this.currentUser)
      }
    );
    this.userBookingService.getUserBookings(this.currentUser.id).subscribe(data => {
      this.bookings = data;
    });
  }

}
