import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';
import * as iziToast from "izitoast";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  hide = true;

  @ViewChild('username')
  username!: ElementRef;
  @ViewChild('password')
  password!: ElementRef;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router:Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }
  onSubmit(): void {
    if (this.username.nativeElement.value && this.password.nativeElement.value) {
      this.authService.login(this.username.nativeElement.value, this.password.nativeElement.value).subscribe(
        data => {
          console.log(data);
          this.tokenStorage.saveToken(data.accessToken);
          this.tokenStorage.saveUser(data);

          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.roles = this.tokenStorage.getUser().roles;
          if (this.roles.includes("DIRECTOR")) {
            this.router.navigate(["/director"]);
          }
          else if (this.roles.includes("ADMIN")) {
            this.router.navigate(["/admin"]);
          }
          else {
            this.router.navigate(["/user"]);
          }
        },
        err => {
          this.errorMessage = err.error.message;
          this.isLoginFailed = true;
        }
      );
    } else {
      this.wrongParamsToast();
    }
  }

  reloadPage(): void {
    window.location.reload();
  }

  wrongParamsToast() {
    iziToast.default.show({
      title: "Wrong email or password!"
    })
  }

}
