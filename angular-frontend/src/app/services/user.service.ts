import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }
  //под методы ниже у нас нет эндпоинтов но пусть будут

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  userMode(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  directorMode(): Observable<any> {
    return this.http.get(API_URL + 'director', { responseType: 'text' });
  }

  adminMode(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
}
