import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { INetworkMaster } from 'app/shared/model/network-master.model';

@Component({
  selector: 'jhi-network-master-detail',
  templateUrl: './network-master-detail.component.html',
})
export class NetworkMasterDetailComponent implements OnInit {
  networkMaster: INetworkMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ networkMaster }) => (this.networkMaster = networkMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
