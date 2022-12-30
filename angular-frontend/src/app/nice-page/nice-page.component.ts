import { Component, OnInit } from '@angular/core';
import {SettingsService} from "../services/settings.service";

@Component({
  selector: 'app-nice-page',
  templateUrl: './nice-page.component.html',
  styleUrls: ['./nice-page.component.css']
})
export class NicePageComponent implements OnInit {

  public rate: number;
  constructor(private settingsService: SettingsService) { }

  ngOnInit(): void {
    this.settingsService.getRate().subscribe(data => {
      this.rate = data;
    });
  }

}
