import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../services/token-storage.service";
import {UserService} from "../services/user.service";
import {User} from "../models/user";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public currentUser: any;
  public userData: User;

  constructor(private userService: UserService,
              private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userService.getUser(this.currentUser.id).subscribe(
      data=> {
        this.userData = data;
      }
    );
  }

}
