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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ClientNotificationsComponent } from './client-notifications/client-notifications.component';
import { CreateAdminComponent } from './create-admin/create-admin.component';
import { NicePageComponent } from './nice-page/nice-page.component';
import { UserBookingComponent } from './user-booking/user-booking.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldControl, MatFormFieldModule} from "@angular/material/form-field";
import {MatNativeDateModule} from "@angular/material/core";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatInputModule} from "@angular/material/input";
import {MatCardFooter, MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatProgressBarModule} from '@angular/material/progress-bar';
//import {MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
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
    FormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatInputModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatProgressBarModule
    //MatTableModule, MatPaginatorModule, MatSortModule
    //MatMomentDateModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
