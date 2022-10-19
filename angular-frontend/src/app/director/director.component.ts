import { Component, OnInit } from '@angular/core';
import {Hotel} from "../models/hotel";
import {DirectorService} from "../services/director.service";

@Component({
  selector: 'app-director',
  templateUrl: './director.component.html',
  styleUrls: ['./director.component.css']
})
export class DirectorComponent implements OnInit {

  public hotel!: Hotel;

  constructor(private directorService: DirectorService) { }

  ngOnInit(): void {
    this.directorService.getHotel().subscribe(
      (hotel) => {
        this.hotel = hotel;
      },
      error => console.warn(error)
    )
  }

}
