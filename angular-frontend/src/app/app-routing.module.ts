import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {DirectorComponent} from "./director/director.component";
import {RoomConstructorComponent} from "./room-constructor/room-constructor.component";
import {AdminNotificationsComponent} from "./admin-notifications/admin-notifications.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'director', component: DirectorComponent},
  { path: 'room-edit', component: RoomConstructorComponent},
  { path: 'admin-notifications', component: AdminNotificationsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
