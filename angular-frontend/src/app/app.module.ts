import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {authInterceptorProviders} from "./helpers/auth.interceptor";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from "./register/register.component";
import {HttpClientModule} from "@angular/common/http";
import { DirectorComponent } from './director/director.component';
import {AdminComponent} from "./admin/admin.component";
import {RoomConstructorComponent} from "./room-constructor/room-constructor.component";
import { AdminListComponent } from './admin-list/admin-list.component';
import { AdminNotificationsComponent } from './admin-notifications/admin-notifications.component';
import { UserComponent } from './user/user.component';
import { BookingComponent } from './booking/booking.component';
import {FormsModule} from "@angular/forms";
import { NgxMatDatetimePickerModule, NgxMatTimepickerModule } from '@angular-material-components/datetime-picker';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldModule} from "@angular/material/form-field";
import { ClientNotificationsComponent } from './client-notifications/client-notifications.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { NicePageComponent } from './nice-page/nice-page.component';
import { UserBookingComponent } from './user-booking/user-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DirectorComponent,
    AdminComponent,
    RoomConstructorComponent,
    AdminListComponent,
    AdminNotificationsComponent,
    UserComponent,
    BookingComponent,
    ClientNotificationsComponent,
    CreateAdminComponent,
    NicePageComponent,
    UserBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    NgxMatTimepickerModule,
    FormsModule,
    NgxMatDatetimePickerModule,
    MatDatepickerModule,
    MatFormFieldModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
