import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hotel} from "../models/hotel";

@Injectable({
  providedIn: 'root'
})
export class DirectorService {


  constructor(private http: HttpClient) { }

 /* private COMPANY_URL: string = Const.LOCALHOST_URL + 'api/company';*/

  public getHotel(): Observable<Hotel> {
    return this.http.get<Hotel>("http://localhost:8080/api/hotel");
  }

  /*public getCompanyByUserId(id: number): Observable<any> {
    return this.http.get<any>(this.COMPANY_URL + "/" + id);
  }

  getCompanyById(id: number): Observable<Company> {
    return this.http.get<Company>(this.COMPANY_URL + "/company/" + id);
  }

  public postCompany(id: number, company: FormGroup) {
    return this.http.post(this.COMPANY_URL + '/' + id, company);
  }*/
}
