import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Admin_Notification} from "../models/admin_notification";
import {Client_Notification} from "../models/client_notification";


@Injectable({
  providedIn: 'root'
})
export class Client_NotificationsService {


  constructor(private http: HttpClient) { }
  public getAllNotifications(id: number): Observable<Client_Notification[]> {
    return this.http.get<Client_Notification[]>("http://localhost:8080/api/notifications/client/" + id);
  }

}
