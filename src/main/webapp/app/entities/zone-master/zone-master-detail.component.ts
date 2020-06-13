import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IZoneMaster } from 'app/shared/model/zone-master.model';

@Component({
  selector: 'jhi-zone-master-detail',
  templateUrl: './zone-master-detail.component.html',
})
export class ZoneMasterDetailComponent implements OnInit {
  zoneMaster: IZoneMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ zoneMaster }) => (this.zoneMaster = zoneMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
