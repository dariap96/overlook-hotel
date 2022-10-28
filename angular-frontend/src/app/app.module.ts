import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {authInterceptorProviders} from "./helpers/auth.interceptor";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from "./register/register.component";
import {HttpClientModule} from "@angular/common/http";
import { DirectorComponent } from './director/director.component';
import {AdminPageComponent} from "./admin-page/admin-page.component";
import {RoomConstructorComponent} from "./room-constructor/room-constructor.component";
import { AdminListComponent } from './admin-list/admin-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DirectorComponent,
    AdminPageComponent,
    RoomConstructorComponent,
    AdminListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
