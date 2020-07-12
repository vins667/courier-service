import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { INetworkMaster } from 'app/shared/model/network-master.model';
import { NetworkMasterService } from './network-master.service';

@Component({
  templateUrl: './network-master-delete-dialog.component.html',
})
export class NetworkMasterDeleteDialogComponent {
  networkMaster?: INetworkMaster;

  constructor(
    protected networkMasterService: NetworkMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.networkMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('networkMasterListModification');
      this.activeModal.close();
    });
  }
}
