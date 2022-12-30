import { Component, OnInit } from '@angular/core';
import {SettingsService} from "../services/settings.service";
import {Table} from "../models/table";
import {Room} from "../models/room";

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

  updateTable(table: Table) {
    this.settingsService.updateTable(table).subscribe(
      () => console.log('Updating correctly'),
      error => console.warn(error)
    )
    this.reloadPage()
  }

  reloadPage() {
    window.location.reload()
  }

  changeMonday(event: any){
    this.table.monday = event.target.value;
    this.updateTable(this.table)
  }

  changeTuesday(event: any){
    this.table.tuesday = event.target.value;
    this.updateTable(this.table)
  }
  changeWednesday(event: any){
    this.table.wednesday = event.target.value;
    this.updateTable(this.table)
  }
  changeThursday(event: any){
    this.table.thursday = event.target.value;
    this.updateTable(this.table)
  }
  changeFriday(event: any){
    this.table.friday = event.target.value;
    this.updateTable(this.table)
  }
  changeSaturday(event: any){
    this.table.saturday = event.target.value;
    this.updateTable(this.table)
  }
  changeSunday(event: any){
    this.table.sunday = event.target.value;
    this.updateTable(this.table)
  }

}
