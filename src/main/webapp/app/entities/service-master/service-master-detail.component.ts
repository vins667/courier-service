import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IServiceMaster } from 'app/shared/model/service-master.model';

@Component({
  selector: 'jhi-service-master-detail',
  templateUrl: './service-master-detail.component.html',
})
export class ServiceMasterDetailComponent implements OnInit {
  serviceMaster: IServiceMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ serviceMaster }) => (this.serviceMaster = serviceMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
