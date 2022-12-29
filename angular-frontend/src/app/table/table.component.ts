import { Component, OnInit } from '@angular/core';
import {SettingsService} from "../services/settings.service";
import {Table} from "../models/table";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  public table: Table;

  constructor(private settingsService: SettingsService) { }



  ngOnInit(): void {
    this.settingsService.getTable().subscribe(data => {
      this.table = data;
    });
  }

}
