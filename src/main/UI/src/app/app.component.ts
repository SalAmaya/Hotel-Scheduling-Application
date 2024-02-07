import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient, HttpResponse,HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import {map} from "rxjs/operators";





@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  WelcomeMessageEnglish$!: Observable<string>;
  WelcomeMessageFrench$!: Observable<string>;

  printAllZones$!: Observable<string>;

  constructor(private httpClient:HttpClient){}

  private baseURL: string = 'http://localhost:8080';
  private getUrl: string = this.baseURL + '/room/reservation/v1/';
  private postUrl: string = this.baseURL + '/room/reservation/v1';
  public submitted!: boolean;
  roomsearch!: FormGroup;
  rooms!: Room[];
  request!: ReserveRoomRequest;
  currentCheckInVal!: string;
  currentCheckOutVal!: string;

  ngOnInit() {
    this.WelcomeMessageEnglish$ = this.httpClient.get(this.baseURL + '/welcome?lang=en-US', { responseType: 'text' });
    this.WelcomeMessageFrench$ = this.httpClient.get(this.baseURL + '/welcome?lang=fr-CA', { responseType: 'text' });

    this.printAllZones$ = this.httpClient.get(this.baseURL + '/convert', { responseType: 'text' });

    this.roomsearch = new FormGroup({
      checkin: new FormControl(' '),
      checkout: new FormControl(' ')
    });


    const roomsearchValueChanges$ = this.roomsearch.valueChanges;

    // subscribe to the stream
    roomsearchValueChanges$.subscribe(x => {
      this.currentCheckInVal = x.checkin;
      this.currentCheckOutVal = x.checkout;
    });
  }

  onSubmit({ value, valid }: { value: Roomsearch, valid: boolean }) {
    this.getAll().subscribe(
        rooms => {
          console.log(Object.values(rooms)[0]);
          this.rooms = <Room[]>Object.values(rooms)[0];

          // Calculate crude conversions and assign to priceCAD and priceEUR
          this.rooms.forEach(room => {
            room.priceCAD = (parseFloat(room.price) * 1.27).toFixed(2); // Assuming 1 CAD = 1.27 USD
            room.priceEUR = (parseFloat(room.price) * 0.88).toFixed(2); // Assuming 1 EUR = 0.88 USD
          });
        }
    );
  }


  reserveRoom(value:string){
    this.request = new ReserveRoomRequest(value, this.currentCheckInVal, this.currentCheckOutVal);

    this.createReservation(this.request);
  }
  createReservation(body:ReserveRoomRequest) {
    let bodyString = JSON.stringify(body); // Stringify payload
    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    // let options = new RequestOptions({headers: headers}); // Create a request option

    const options = {
      headers: new HttpHeaders().append('key', 'value'),

    }

    this.httpClient.post(this.postUrl, body, options)
      .subscribe(res => console.log(res));
  }

  /*mapRoom(response:HttpResponse<any>): Room[]{
    return response.body;
  }*/

  getAll(): Observable<any> {


    return this.httpClient.get(this.baseURL + '/room/reservation/v1?checkin='+ this.currentCheckInVal + '&checkout='+this.currentCheckOutVal, {responseType: 'json'});
  }

}



export interface Roomsearch{
  checkin:string;
  checkout:string;
}




export interface Room{
  id: string;
  roomNumber: string;
  price: string;
  links: string;
  priceCAD: string; // Add priceCAD variable
  priceEUR: string; // Add priceEUR variable

}
export class ReserveRoomRequest {
  roomId:string;
  checkin:string;
  checkout:string;

  constructor(roomId:string,
              checkin:string,
              checkout:string) {

    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}

/*
var ROOMS: Room[]=[
  {
  "id": "13932123",
  "roomNumber" : "409",
  "price" :"20",
  "links" : ""
},
{
  "id": "139324444",
  "roomNumber" : "509",
  "price" :"30",
  "links" : ""
},
{
  "id": "139324888",
  "roomNumber" : "609",
  "price" :"40",
  "links" : ""
}
] */

