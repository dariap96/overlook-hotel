import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
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

  @ViewChild('numberCreate')
  number: ElementRef;

  @ViewChild('vipStatusCreate')
  vipStatus: ElementRef;

  @ViewChild('priceCreate')
  price: ElementRef;

  @ViewChild('numberOfPeopleCreate')
  numberOfPeople: ElementRef;

  @ViewChild('floorCreate')
  floor: ElementRef;

  @ViewChild('stageCount')
  stageCount: ElementRef;


  constructor(private roomConstructorService: RoomConstructorService) {
  }

  ngOnInit(): void {
    this.roomConstructorService.getAllRooms().subscribe(data => {
      this.rooms = data.sort((room1, room2) => room1.number - room2.number);
    });
    this.roomConstructorService.getHotel().subscribe(data => {
      this.hotel = data;
    });
  }

  postRoom(room: Room) {
    this.roomConstructorService.postRoom(room).subscribe(
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


  deleteRoom(room: Room) {
    this.roomConstructorService.deleteRoom(room).subscribe(
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
    room.status = newValue

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
    this.deleteRoom(room)
    this.hotel.roomCount-=1
    this.updateHotel()
  }

  createNewRoom() {
    const number = this.number.nativeElement.value
    const vipStatus = this.vipStatus.nativeElement.checked
    const price = this.price.nativeElement.value
    const numberOfPeople = this.numberOfPeople.nativeElement.value
    const stage = this.floor.nativeElement.value
    let room = new Room()
    room.number = number
    room.price = price
    room.status = vipStatus
    room.countPeople = numberOfPeople
    room.stage = stage
    this.postRoom(room)
    this.hotel.roomCount+=1
    this.updateHotel()
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
    event.target.checked = room.status
    let index = this.rooms.indexOf(room)
    let elem = this.vipStatuses.get(index)!.nativeElement
    elem.checked = room.status
  }

  reloadPage() {
    window.location.reload()
  }

  changeFloors() {
    const stageCount = this.stageCount.nativeElement.value
    this.hotel.stageCount = stageCount
    this.updateHotel()
  }
}
