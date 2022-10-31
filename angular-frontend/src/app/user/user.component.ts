import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../services/token-storage.service";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public currentUser: any;

  constructor(private userService: UserService,
              private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    console.log(this.currentUser);
  }

}
