import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import * as iziToast from "izitoast";

@Component({
  selector: 'app-create-admin',
  templateUrl: './create-admin.component.html',
  styleUrls: ['./create-admin.component.css']
})
export class CreateAdminComponent implements OnInit {

  @ViewChild('name')
  name !: ElementRef;

  @ViewChild('email')
  email !: ElementRef;

  @ViewChild('password')
  password !: ElementRef;

  @ViewChild('real_name')
  realName !: ElementRef;

  @ViewChild('surname')
  surname!: ElementRef;

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router:Router) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.name.nativeElement.value && this.email.nativeElement.value && this.password.nativeElement.value) {
      this.authService.registerAdmin(this.name.nativeElement.value, this.email.nativeElement.value,
        this.password.nativeElement.value, this.realName.nativeElement.value, this.surname.nativeElement.value).subscribe(
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
