import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from "../models/user";
import {Room} from "../models/room";

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  public getUser(id: number): Observable<User> {
    return this.http.get<User>("http://localhost:8080/api/users/user/"+id);
  }

  public getOnlyUsersRole(): Observable<User[]> {
     return this.http.get<User[]>("http://localhost:8080/api/users");
  }

}
