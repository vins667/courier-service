import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICountryMaster } from 'app/shared/model/country-master.model';

@Component({
  selector: 'jhi-country-master-detail',
  templateUrl: './country-master-detail.component.html',
})
export class CountryMasterDetailComponent implements OnInit {
  countryMaster: ICountryMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ countryMaster }) => (this.countryMaster = countryMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
