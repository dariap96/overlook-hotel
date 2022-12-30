import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {DirectorComponent} from "./director/director.component";
import {RoomConstructorComponent} from "./room-constructor/room-constructor.component";
import {AdminNotificationsComponent} from "./admin-notifications/admin-notifications.component";
import {UserComponent} from "./user/user.component";
import {BookingComponent} from "./booking/booking.component";
import {AdminComponent} from "./admin/admin.component";
import {AdminListComponent} from "./admin-list/admin-list.component";
import {CreateAdminComponent} from "./create-admin/create-admin.component";
import {ClientNotificationsComponent} from "./client-notifications/client-notifications.component";
import {NicePageComponent} from "./nice-page/nice-page.component";
import {UserBookingComponent} from "./user-booking/user-booking.component";
import {TableComponent} from "./table/table.component";
import {ClientListComponent} from "./client-list/client-list.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  // { path: '', redirectTo: 'nice', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'director', component: DirectorComponent},
  { path: 'room-edit', component: RoomConstructorComponent},
  { path: 'admin-notifications', component: AdminNotificationsComponent},
  { path: 'user', component: UserComponent},
  { path: 'booking', component: BookingComponent},
  { path: 'admin', component: AdminComponent },
  { path: 'admin-list', component: AdminListComponent },
  { path: 'create-admin', component: CreateAdminComponent },
  { path: 'notifications', component: ClientNotificationsComponent },
  { path: '', component: NicePageComponent},
  // { path: 'nice', component: NicePageComponent },
  { path: 'user-booking', component: UserBookingComponent},
  { path: 'table', component: TableComponent},
  { path: 'clients', component: ClientListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
