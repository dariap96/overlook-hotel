import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {AdminListService} from "../services/admin-list.service";
import {ClientListService} from "../services/client-list.service";

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  public clients: Array<User>;

  constructor(private clientListService: ClientListService) { }

  ngOnInit(): void {
    this.clientListService.getAllClients().subscribe(data => {
      this.clients = data;
    });
  }

}
