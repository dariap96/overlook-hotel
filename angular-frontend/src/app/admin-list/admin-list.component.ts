import { Component, OnInit } from '@angular/core';
import {AdminListService} from "../services/admin-list.service";
import {Room} from "../models/room";
import {User} from "../models/user";


@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  public admins: Array<User>;

  constructor(private adminListService: AdminListService) { }

  ngOnInit(): void {
    this.adminListService.getAllAdmins().subscribe(data => {
      this.admins = data;
    });
  }

  removeAdmin(admin: User) {
    console.log(admin);
    this.adminListService.deleteAdmin(admin).subscribe(
      () => console.log('Deleting correctly'),
      error => console.warn(error)
    )
    //this.reloadPage();
  }

  reloadPage() {
    window.location.reload()
  }
}
