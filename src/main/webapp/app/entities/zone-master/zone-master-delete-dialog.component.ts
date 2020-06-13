import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IZoneMaster } from 'app/shared/model/zone-master.model';
import { ZoneMasterService } from './zone-master.service';

@Component({
  templateUrl: './zone-master-delete-dialog.component.html',
})
export class ZoneMasterDeleteDialogComponent {
  zoneMaster?: IZoneMaster;

  constructor(
    protected zoneMasterService: ZoneMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.zoneMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('zoneMasterListModification');
      this.activeModal.close();
    });
  }
}
