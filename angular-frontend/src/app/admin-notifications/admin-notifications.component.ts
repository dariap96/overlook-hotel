import { Component, OnInit } from '@angular/core';
import {RoomConstructorService} from "../services/room-constructor.service";
import {Admin_NotificationsService} from "../services/admin_notifications.service";
import {Room} from "../models/room";
import {Admin_Notification} from "../models/admin_notification";

@Component({
  selector: 'app-admin-notifications',
  templateUrl: './admin-notifications.component.html',
  styleUrls: ['./admin-notifications.component.css']
})
export class AdminNotificationsComponent implements OnInit {

  public notifications!: Array<Admin_Notification>;

  constructor(private adminNotificationsService: Admin_NotificationsService) { }

  ngOnInit(): void {
    this.adminNotificationsService.getAllNotifications().subscribe(data => {
      this.notifications = data;
    });
  }

}
