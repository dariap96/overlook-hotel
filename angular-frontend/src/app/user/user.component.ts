import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TokenStorageService} from "../services/token-storage.service";
import {UserService} from "../services/user.service";
import {User} from "../models/user";
import {NotificationService} from "../services/notification.service";
import {Notification} from "../models/notification";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css', './hystmodal.min.css']
})
export class UserComponent implements OnInit {

  public currentUser: User;
  public show = false;

  @ViewChild("notificationText")
  notificationText: ElementRef

  constructor(private userService: UserService,
              private token: TokenStorageService,
              private notificationService: NotificationService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userService.getUser(this.currentUser.id).subscribe(
      data=> {
        this.currentUser = data;
        console.log(this.currentUser)
      }
    );
  }

  sendNotification() {
    let notification = new Notification()
    const text = this.notificationText.nativeElement.value
    notification.info = text
    notification.fromClientId = this.currentUser.id
    this.notificationService.postNotification(notification).subscribe(
      () => console.log('Posting correctly'),
      error => console.warn(error)
    )
    window.location.reload();
  }


  showPopUp() {
    this.show = true;
    console.log(this.show)
  }

  closePopUp() {
    this.show = false
  }

  closePopUpOverlay(e: any) {
    if (e.target.classList.contains('overlay')) {
      this.show = false;
    }
  }

  routeToBooking() {
    window.location.replace("/booking")
  }
}
