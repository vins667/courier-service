import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICityMaster } from 'app/shared/model/city-master.model';

@Component({
  selector: 'jhi-city-master-detail',
  templateUrl: './city-master-detail.component.html',
})
export class CityMasterDetailComponent implements OnInit {
  cityMaster: ICityMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cityMaster }) => (this.cityMaster = cityMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
