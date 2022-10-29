import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Admin_Notification} from "../models/admin_notification";


@Injectable({
  providedIn: 'root'
})
export class Admin_NotificationsService {


  constructor(private http: HttpClient) { }
  public getAllNotifications(): Observable<Admin_Notification[]> {
    return this.http.get<Admin_Notification[]>("http://localhost:8080/api/notifications/admin");
  }

}
