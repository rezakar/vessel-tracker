import {Component, OnInit} from '@angular/core';
import {Vessel} from "../../commom/vessel";
import {VesselService} from "../../services/vessel.service";

@Component({
  selector: 'app-vessel',
  templateUrl: './vessel.component.html',
  styleUrls: ['./vessel.component.css']
})
export class VesselComponent implements OnInit {

  vessels: Vessel[];

  XDev: number[];
  YDev: number[];
  timestamp: string[];
  types = [];


  constructor(private vesselService: VesselService) {
  }

  ngOnInit(): void {
    this.handleVessels();
  }

  handleVessels() {
    this.vesselService.getVesselList().subscribe(
      data => {
        this.vessels = data;
        // console.log(this.vessels);
        // console.log(this.vessels.forEach(temp => this.getVesselSpeed(temp)));
      }
    );

  }
}
