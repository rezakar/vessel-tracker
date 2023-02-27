import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VesselComponent } from './components/vessel/vessel.component';
import {HttpClientModule} from "@angular/common/http";
import {VesselService} from "./services/vessel.service";
import { VesselTrackerComponent } from './components/vessel-tracker/vessel-tracker.component';
import {VesselTrackerService} from "./services/vessel-tracker.service";

@NgModule({
  declarations: [
    AppComponent,
    VesselComponent,
    VesselTrackerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [VesselService, VesselTrackerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
