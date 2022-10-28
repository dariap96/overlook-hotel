import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Room} from "../models/room";
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class AdminListService {

  constructor(private http: HttpClient) { }

  public getAllAdmins(): Observable<User[]> {
    return this.http.get<User[]>("http://localhost:8080/api/admins");
  }
}
