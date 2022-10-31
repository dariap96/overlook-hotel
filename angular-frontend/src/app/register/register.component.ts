import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { AuthService } from '../services/auth.service';
import * as iziToast from "izitoast";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @ViewChild('name')
  name !: ElementRef;

  @ViewChild('email')
  email !: ElementRef;

  @ViewChild('password')
  password !: ElementRef;

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router:Router) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.name.nativeElement.value && this.email.nativeElement.value && this.password.nativeElement.value) {
      this.authService.register(this.name.nativeElement.value, this.email.nativeElement.value,
        this.password.nativeElement.value).subscribe(
        data => {
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
          this.router.navigate(["/login"]);
        },
        err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      );
    } else {
      this.wrongParamsToast()
    }
  }
  wrongParamsToast() {
    iziToast.default.show({
      title: "Wrong email or password!"
    })
  }
}
