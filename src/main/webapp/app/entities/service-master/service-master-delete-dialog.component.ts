import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IServiceMaster } from 'app/shared/model/service-master.model';
import { ServiceMasterService } from './service-master.service';

@Component({
  templateUrl: './service-master-delete-dialog.component.html',
})
export class ServiceMasterDeleteDialogComponent {
  serviceMaster?: IServiceMaster;

  constructor(
    protected serviceMasterService: ServiceMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.serviceMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('serviceMasterListModification');
      this.activeModal.close();
    });
  }
}
