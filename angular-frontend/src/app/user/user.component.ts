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
  public showNotification = false;
  public showRate = false;

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

  showNotificationPopUp() {
    this.showNotification = true;
  }

  closeNotificationPopUp() {
    this.showNotification = false
  }

  closeNotificationPopUpOverlay(e: any) {
    if (e.target.classList.contains('overlay')) {
      this.showNotification = false;
    }
  }

  showRatePopUp() {
    this.showRate = true;
  }

  closeRatePopUp() {
    this.showRate = false
  }

  closeRatePopUpOverlay(e: any) {
    if (e.target.classList.contains('overlay')) {
      this.showRate = false;
    }
  }

  routeToBooking() {
    window.location.replace("/booking")
  }
}
