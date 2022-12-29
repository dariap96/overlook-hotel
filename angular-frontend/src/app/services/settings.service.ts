import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";
import {Table} from "../models/table";

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  constructor(private http: HttpClient) { }

  public getTable(): Observable<Table> {
    return this.http.get<Table>("http://localhost:8080/api/settings/table");
  }

  public getRate(): Observable<number> {
    return this.http.get<number>("http://localhost:8080/api/settings/rate");
  }

  public updateTable(table: Table){
    return this.http.patch("http://localhost:8080/api/settings/table", table);
  }

  public updateRate(rate: String){
    return this.http.patch("http://localhost:8080/api/settings/rate", rate);
  }
}
