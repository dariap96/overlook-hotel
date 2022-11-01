import {Component, ElementRef, OnInit} from '@angular/core';
import {Room} from "../models/room";
import {RoomConstructorService} from "../services/room-constructor.service";
import {Hotel} from "../models/hotel";
import { ViewChildren, QueryList } from '@angular/core';

@Component({
  selector: 'app-room-constructor',
  templateUrl: './room-constructor.component.html',
  styleUrls: ['./room-constructor.component.css', './checkbox.css', './hystmodal.min.css']
})
export class RoomConstructorComponent implements OnInit {

  public rooms!: Array<Room>;
  public room!: Room;
  public hotel!: Hotel;
  public show = false;

  @ViewChildren('number')
  numbers: QueryList<ElementRef>;

  @ViewChildren('vipStatus')
  vipStatuses: QueryList<ElementRef>;

  @ViewChildren('price')
  prices: QueryList<ElementRef>;

  @ViewChildren('numberOfPeople')
  numberOfPeoples: QueryList<ElementRef>;

  @ViewChildren('floor')
  floors: QueryList<ElementRef>;

  constructor(private roomConstructorService: RoomConstructorService) {
  }

  ngOnInit(): void {
    this.roomConstructorService.getAllRooms().subscribe(data => {
      this.rooms = data;
    });
    this.roomConstructorService.getHotel().subscribe(data => {
      this.hotel = data;
    });
  }

  postRoom() {
    this.roomConstructorService.postRoom(this.room).subscribe(
      () => console.log('Posting correctly'),
      error => console.warn(error)
    )
    this.reloadPage();
  }

  updateRoom(room: Room) {
    this.roomConstructorService.updateRoom(room).subscribe(
      () => console.log('Updating correctly'),
      error => console.warn(error)
    )
    this.reloadPage()
  }


  deleteRoom() {
    this.roomConstructorService.deleteRoom(this.room).subscribe(
      () => console.log('Deleting correctly'),
      error => console.warn(error)
    )
    this.reloadPage();
  }

  updateHotel() {
    this.roomConstructorService.updateHotel(this.hotel).subscribe(
      () => console.log('Updating correctly'),
      error => console.warn(error)
    )
    this.reloadPage()
  }

  numberChanged(room: Room) {
    let index = this.rooms.indexOf(room)
    let newValue = this.numbers.get(index)?.nativeElement.value
    room.number = newValue
    this.updateRoom(room)
  }

  statusChanged(room: Room) {
    let index = this.rooms.indexOf(room)
    let newValue = this.vipStatuses.get(index)?.nativeElement.checked
    if (newValue)
    {
      room.status = "VIP";
    }
    else{
      room.status = "normal";
    }

    this.updateRoom(room)
  }

  priceChanged(room: Room) {
    let index = this.rooms.indexOf(room)
    let newValue = this.prices.get(index)?.nativeElement.value
    room.price = newValue
    this.updateRoom(room)
  }
  countPeopleChanged(room: Room) {
    let index = this.rooms.indexOf(room)
    let newValue = this.numberOfPeoples.get(index)?.nativeElement.value
    room.countPeople = newValue
    this.updateRoom(room)
  }

  stageChanged(room: Room) {
    let index = this.rooms.indexOf(room)
    let newValue = this.floors.get(index)?.nativeElement.value
    room.stage = newValue
    this.updateRoom(room)
  }

  removeRoom(room: Room) {

  }

  createNewRoom() {

  }

  showPopUp() {
    this.show = true;
  }

  closePopUp() {
    this.show = false
  }

  closePopUpOverlay(e: any) {
    if (e.target.classList.contains('overlay')) {
      this.show = false;
    }

  }

  setLabelSelected(room: Room, event: any) {
    event.target.checked = !event.target.checked
    let index = this.rooms.indexOf(room)
    let elem = this.vipStatuses.get(index)!.nativeElement
    elem.checked = !elem.checked
  }

  setInitialSelected(room: Room, event: any) {
    event.target.checked = room.status == 'VIP'
    let index = this.rooms.indexOf(room)
    let elem = this.vipStatuses.get(index)!.nativeElement
    elem.checked = room.status == 'VIP'
  }

  reloadPage() {
    window.location.reload()
  }
}
