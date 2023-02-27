import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vessel} from "../commom/vessel";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class VesselService {

  private baseUrl = 'http://localhost:8080/allVessel'

  constructor(private httpClient: HttpClient) {
  }

  getVesselList(): Observable<Vessel[]> {

    const response =  this.httpClient.get<Vessel[]>(this.baseUrl).pipe(
      map(response => response)
    );

    return response;
  }
}

interface GetResponseVessel {
  _embedded: {
    vessels: Vessel[];
  }
}
