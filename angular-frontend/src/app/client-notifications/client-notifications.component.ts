import { Component, OnInit } from '@angular/core';
import {Admin_Notification} from "../models/admin_notification";
import {Admin_NotificationsService} from "../services/admin_notifications.service";
import {Client_Notification} from "../models/client_notification";
import {Client_NotificationsService} from "../services/client_notification.service";
import {User} from "../models/user";
import {UserService} from "../services/user.service";
import {TokenStorageService} from "../services/token-storage.service";

@Component({
  selector: 'app-client-notifications',
  templateUrl: './client-notifications.component.html',
  styleUrls: ['./client-notifications.component.css']
})
export class ClientNotificationsComponent implements OnInit {

  public notifications!: Array<Client_Notification>;
  public currentUser: User;

  constructor(private clientNotificationsService: Client_NotificationsService,
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
    this.clientNotificationsService.getAllNotifications(this.currentUser.id).subscribe(data => {
      this.notifications = data;
    });
  }

}
