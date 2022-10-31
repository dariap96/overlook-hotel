import { Component, OnInit } from '@angular/core';
import {Admin_NotificationsService} from "../services/admin_notifications.service";
import {NotificationService} from "../services/notification.service";
import {Room} from "../models/room";
import {Notification} from "../models/notification";

@Component({
  selector: 'app-leave-request',
  templateUrl: './leave-request.component.html',
  styleUrls: ['./leave-request.component.css']
})
export class LeaveRequestComponent implements OnInit {

  public notification!: Notification;

  constructor(private notificationService: NotificationService) { }

  ngOnInit(): void {
  }

  postRoom() {
    this.notificationService.postNotification(this.notification).subscribe(
      () => console.log('Posting correctly'),
      error => console.warn(error)
    )
    window.location.reload();
  }

}
