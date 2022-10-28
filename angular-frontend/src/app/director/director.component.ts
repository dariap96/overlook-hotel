import { Component, OnInit } from '@angular/core';
import {Hotel} from "../models/hotel";
import {DirectorService} from "../services/director.service";
import {TokenStorageService} from "../services/token-storage.service";

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  public currentUser: any;
  public hotel!: Hotel;

  constructor(private directorService: DirectorService, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    console.log(this.currentUser);
    this.directorService.getHotel().subscribe(
      (hotel) => {
        this.hotel = hotel;
      },
      error => console.warn(error)
    )
  }

}
