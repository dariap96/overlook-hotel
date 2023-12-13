import {Component, ViewChild} from '@angular/core';
import {TokenStorageService} from "./services/token-storage.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'yalalka';
  private roles: string[] = [];
  isLoggedIn = false;
  adminMode = false;
  directorMode = false;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.adminMode = this.roles.includes('ADMIN');
      this.directorMode = this.roles.includes('MODERATOR');
      this.username = user.username;
    }
  }
}
