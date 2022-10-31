import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Room} from "../models/room";
import {Notification} from "../models/notification";


@Injectable({
  providedIn: 'root'
})
export class NotificationService {


  constructor(private http: HttpClient) { }

  public postNotification(notification: Notification) {
    return this.http.post("http://localhost:8080/api/notifications", notification);
  }

}
