import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IStandardTariff } from 'app/shared/model/standard-tariff.model';

@Component({
  selector: 'jhi-standard-tariff-detail',
  templateUrl: './standard-tariff-detail.component.html',
})
export class StandardTariffDetailComponent implements OnInit {
  standardTariff: IStandardTariff | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ standardTariff }) => (this.standardTariff = standardTariff));
  }

  previousState(): void {
    window.history.back();
  }
}
